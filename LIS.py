Using DP:
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we traverse through the whole input and for every index i we check with the previous elements before i to count the number of elements greater than the current element.

# Time complexity --> o(n*n)
# space complexity --> o(n)
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums==None or len(nums)==0:
            return 0
         #Intialising to 1 to mean that each digit is a sequence of length 1.
        out=[1 for i in range(len(nums))]
        
        for i in range(1,len(nums)):
            #for every index i we check with the prev elements before i to make sure we take only the ascending order of elements
            for j in range(i-1,-1,-1):
                if nums[i]>nums[j]:
                    #If yes then we increment 1 saying that we have another number that can be added to make it as a ascending order.
                    out[i]=max(out[i],1+out[j])
        return max(out)
       
using Binary search
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this procedure we traverse through the whole list.If the current index element in input is greater than the last element in the out list then we add the element to the list else we do binary search on the out array and replace the current index element.
In the end the length of the out array gives the result.

# using Binary search logic
# Time complexity --> o(nlogn)
# space complexity --> o(n)
class Solution(object):
    def binarysearch(self,out,val):
        low=0
        high=len(out)-1
        while(low<high):
            mid=low+((high-low)/2)
            if val>out[mid]:
                low=mid+1
            else:
                high=mid
        return low
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums==None or len(nums)==0:
            return 0
        out=[nums[0]]
        for i in range(1,len(nums)):
        #check if the current element is greater than the last element in the out array.If yes we add it to the out array.
            if nums[i]>out[-1]:
                out.append(nums[i])
            else:
            #we do binary search on the out array to find the index where the current index val is to be replaced.
                index=self.binarysearch(out,nums[i])
                out[index]=nums[i]
            #     print(index)
            # print(out,nums[i])
        return len(out)
