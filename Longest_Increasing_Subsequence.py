# Time Complexity : O(n*log(n))
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
class Solution:
    def binarySearch(self, nums, target):
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == target:
                return mid
            elif mid >= 0 and nums[mid] > target:
                end = mid - 1
            elif mid < len(nums) and nums[mid] <= target:
                start = mid + 1
        return start if 0 <= start < len(nums) else -1

    def lengthOfLIS(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return 1
        result = [nums[0]]
        for i in range(1, len(nums)):
            if len(result) == 1 and nums[i] < result[-1]:
                result = [nums[i]]
            elif result[-1] < nums[i]:
                result.append(nums[i])
            else:
                index = self.binarySearch(result, nums[i])
                if index != -1:
                    result[index] = nums[i]
        return len(result)


print(Solution().lengthOfLIS([0, 1, 0, 3, 2, 3]))


# TC: O(n^2); SC: O(n)
# class Solution:
#     def lengthOfLIS(self, nums: list[int]) -> int:
#         dp = [1]*len(nums)
#         for i in range(1, len(nums)):
#             for j in range(0, i):
#                 if nums[j] < nums[i]:
#                     dp[i] = max(dp[i], dp[j]+1)
#         return max(dp)
#
#
# print(Solution().lengthOfLIS([0, 1, 0, 3, 2, 3]))


# TC: O(n^2); SC: O(n)
# follow-up for the sequence.
# class Solution:
#     def lengthOfLIS(self, nums: list[int]) -> int:
#         dp = []
#         maxi = 1
#         for i in nums:
#             dp.append([i])
#         for i in range(1, len(nums)):
#             for j in range(0, i):
#                 temp = dp[j] + [nums[i]]
#                 if nums[j] < nums[i] and len(temp) > len(dp[i]):
#                     dp[i] = temp
#                     maxi = max(maxi, len(temp))
#         return maxi
#
#
# print(Solution().lengthOfLIS([0, 1, 0, 3, 2, 3]))


# Brute-Force
# TC: exponential
# class Solution:
#     def helper(self, nums, index, sequence):
#         # base
#         if index == len(nums):
#             return
#         # logic
#         self.helper(nums, index+1, sequence)
#         if not sequence or nums[index] > sequence[-1]:
#             sequence.append(nums[index])
#             self.max = max(self.max, len(sequence))
#             self.helper(nums, index+1, sequence)
#             sequence.pop()
#
#     def lengthOfLIS(self, nums: list[int]) -> int:
#         self.max = 1
#         self.helper(nums, 0, [])
#         return self.max
#
#
# print(Solution().lengthOfLIS([0, 1, 0, 3, 2, 3]))
