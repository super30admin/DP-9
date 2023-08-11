class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # Time Complexity: O(n^2) - Two nested loops, each running up to n
        # Space Complexity: O(n) - Extra space is used to store the dp array
        if nums is None or len(nums) == 0:
            return 0

        n = len(nums)
        # Initialize an array to store the length of LIS ending at each index
        dp = [1] * n
        longest = 1  # Initialize the variable to store the longest LIS length

        for i in range(1, n):
            for j in range(i):
                if nums[j] < nums[i]:
                    # Update LIS length at index i
                    dp[i] = max(dp[i], dp[j] + 1)
                    # Update the longest LIS length
                    longest = max(longest, dp[i])

        return longest  # Return the longest LIS length
