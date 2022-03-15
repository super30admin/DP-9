'''
TC: O(n^2)
SC: O(n)
'''
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        
        dp = [1 for i in nums]
        
        for i in range(1, len(nums)):
            maxm = 0
            for j in range(i+1):
                if nums[j] < nums[i]:
                    maxm = max(maxm, dp[j])
            dp[i] += maxm
        
        return max(dp)
            
        