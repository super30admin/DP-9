# The lengthOfLIS method calculates the length of the longest increasing subsequence (LIS) in an array.

# Dynamic Programming Approach:
# - Use a `LIS` array where `LIS[i]` represents the length of the LIS starting at index `i`.
# - Traverse the array from right to left:
#   - For each element, check subsequent elements to find a longer subsequence.
#   - Update `LIS[i]` to the maximum length found.

# Return the maximum value in the `LIS` array as the result.

# TC: O(n^2) - Nested loops for pairwise comparisons.
# SC: O(n) - Space for the `LIS` array.


from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        LIS = [1] * len(nums)

        for i in range(len(nums) - 1, -1, -1):
            for j in range(i + 1, len(nums)):
                if nums[i] < nums[j]:
                    LIS[i] = max(LIS[i], 1 + LIS[j])
        return max(LIS)