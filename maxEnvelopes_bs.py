"""
Time complexity = O(nlogn) 
Space Complexity=  O(n)

Time limit exceed for DP solution 

-similar to the longest increasing subsequence problem. 
- sort the envelopes array in increasing order of first index and decreasing order of second index and same as longest increasing subsequence problem 

"""

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        envelopes.sort(key=lambda x:(x[0],-x[1]))
        
        arr=[0 for _ in range(len(envelopes))]
        arr[0]=envelopes[0]
        idx=1
        for i in range(1,len(envelopes)):
            if(envelopes[i][1]>arr[idx-1][1]):
                arr[idx]=envelopes[i]
                idx+=1
            else:
                bIdx=self.binarysearch(arr,0,idx-1,envelopes[i][1]) #to find index of the next highest element of nums[i] in arr[]
                arr[bIdx]=envelopes[i]
        return idx
        
    def binarysearch(self,arr,l,h,target): 
        while l<=h: #closest binary search 
            mid=l+(h-l)//2
            if arr[mid][1]==target:
                return mid
            elif arr[mid][1]>target:
                h=mid-1
            else:
                l=mid+1
        return l