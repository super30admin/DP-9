# 300. Longest Increasing Subsequence
# https://leetcode.com/problems/longest-increasing-subsequence/

# Logic: We have a dp array. We initialize it with 1 as the maximum possiple LIS is 1. 
# Then we start iterating over the input. For each input, we check all the values 
# before it in the input and check if it is less than the current value, we take max 
# of its count from dp +1 and count of current guy.

# Time Complexity: O(n*n)
# Space Complexity: O(n)

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        n = len(nums)
        dp = [1 for i in range(n)]
        
        max_val = 1
        for i in range(n):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[j]+1, dp[i])
                    max_val = max(max_val, dp[i])
        
        return max_val