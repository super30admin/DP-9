# Time Complexity : O(N^2)
# Space Complexity : O()
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using DP Approach. Tkae 2 pointers i and j where i = 1 and j = 0
# Initialize dp array to 1 with length of nums array and maxcount = 1 since we dont need to go throgh the array again to get the maximum
# Iterate over the nums array and then iterate j until it reaches i to check every element whether it is smaller then current element at index i
# Check if element at index is greater than element at index j
# If it is then take the maximum between the current element in dp at index i and element at index j in dp array + 1
# Return maximum count in dp array


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return None

        dp = [1] * len(nums)
        maxcount = 1
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    maxcount = max(maxcount, dp[i])
        return maxcount