# Time Complexity : O(n^2), where n is the length of the input array
# Space Complexity : O(n)
class Solution:
    def lengthOfLIS(self, nums):
        if len(nums) == 0:
            return 0
        
        maxLength = 0
        dp = [1] * len(nums)  # Min length is 1
        
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        
        for length in dp:
            maxLength = max(maxLength, length)
        
        return maxLength

# Examples

# Example 1
nums = [10, 9, 2, 5, 3, 7, 101, 18]
sol = Solution()
print(sol.lengthOfLIS(nums))  # Output: 4

# Example 2
nums = [0, 1, 0, 3, 2, 3]
sol = Solution()
print(sol.lengthOfLIS(nums))  # Output: 4

# Example 3
nums = [7, 7, 7, 7, 7, 7, 7]
sol = Solution()
print(sol.lengthOfLIS(nums))  # Output: 1