"""
Time complexity O(N^2)
Space complexity O(N)

"""

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        dp=[1]*len(nums)
        
        max1=1
        for i in range(1,len(dp)):
            for j in range(i):#resetting j every time and move tem till i 
                if(nums[i]>nums[j]): #if nums[i] is greater increase the no of longest subsequence value filled in dp array 
                    dp[i]=max(dp[i],dp[j]+1)
                    
                    max1=max(max1,dp[i])
        
        return max1