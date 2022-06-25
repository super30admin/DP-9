class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums or len(nums)==0:
            return 0
        
        dp=[1 for i in range(len(nums))]
        result=1
        
        for i in range(len(nums)):
            maxLen=1
            for j in range(i):
                if nums[i]>nums[j]:
                    maxLen=max(maxLen,dp[j]+1)
                
            dp[i]=maxLen
            result=max(result,dp[i])
            
        return result
            
                
                
                
            
        