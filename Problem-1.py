#Time Complexity :o(nlogn)
#Space Complexity :o(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(nums==None or len(nums)==0):
            return 0
        
        
        dp=[nums[0]]
        
        for i in range(1,len(nums)):
            if(nums[i]>dp[-1]):
                dp.append(nums[i])
            else:
                ind=self.BS(dp,nums[i])
                dp[ind]=nums[i]
        
        return len(dp)
    
    
    def BS(self,arr,target):
        low=0
        high=len(arr)-1
        
        while low<=high:
            mid=low+(high-low)//2
            
            if(arr[mid]==target):
                return mid
            if(arr[mid]<target):
                low=mid+1
            else:
                high=mid-1
        
        return low
            
            