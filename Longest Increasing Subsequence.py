""""// Time Complexity : O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1]*len(nums)
        maxi=1
        for i in range(1, len(nums)):
            for j in range(0, i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j]+1)
                    maxi=max(maxi, dp[i])
        return maxi



""""// Time Complexity : O(nlog(n))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


# class Solution:
#     def lengthOfLIS(self, nums: List[int]) -> int:
#         n = len(nums)
#         arr = [0] * n
#         arr[0] = nums[0]
#         length = 1
#
#         for i in range(1, n):
#             if nums[i] > arr[length - 1]:
#                 arr[length] = nums[i]
#                 length += 1
#             else:
#                 bsIdx = self.binarySearch(arr, 0, length - 1, nums[i])
#                 arr[bsIdx] = nums[i]
#
#         return length
#
#     def binarySearch(self, arr, low, high, target):
#         while low <= high:
#             mid = low + (high - low) // 2
#
#             if arr[mid] == target:
#                 return mid
#             elif arr[mid] < target:
#                 low = mid + 1
#             else:
#                 high = mid - 1
#         return low
