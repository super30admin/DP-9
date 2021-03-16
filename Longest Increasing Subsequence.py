class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        #Approach: Dynamic Programming
        #Time Complexity: O(n^2)
        #Space Complexity: O(1)
        #where, n is the length of nums
        
        dp = [1 for _ in nums]
        result = 1
        
        for i in range(1, len(dp)):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
            result = max(result, dp[i])
                    
        return result