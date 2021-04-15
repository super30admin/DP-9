#Time Complexity :O(nlogn)
#Space Complexity :O(n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        if(envelopes==None or len(envelopes)==0):
            return 0
        
        envelopes.sort(key=lambda x: (x[0],-x[1]))
        arr=[envelopes[0]]
        for i in range(1,len(envelopes)):
            curr=envelopes[i]
            if(curr[0] > arr[-1][0] and curr[1] > arr[-1][1]):
                arr.append(curr)
            elif(curr[0]<arr[-1][0]):
                index=self.BS(curr[0],arr,0)
                arr[index]=curr
            elif(curr[1]<arr[-1][1]):
                index=self.BS(curr[1],arr,1)
                arr[index]=curr
            
        return len(arr)
    
    def BS(self,target,arr,ind):
        low=0
        high=len(arr)-1
        while low<=high:
            mid=low+(high-low)//2
            if(arr[mid][ind]==target):
                return mid
            if(target<arr[mid][ind]):
                high=mid-1
            else:
                low=mid+1
        
        return low