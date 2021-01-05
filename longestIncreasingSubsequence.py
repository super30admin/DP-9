#Time Complexity : O(nlogn) where n is the length of the input array
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def binarySearch(self, arr, l, h, target):
        while l <= h:
            m = l + (h-l)//2
            if arr[m] == target:
                return m
            elif arr[m] > target:
                h = m - 1
            else:
                l = m + 1
        return l

    def lengthOfLIS(self, nums: List[int]) -> int:
        sortedArray = [0 for _ in range(len(nums))]
        sortedArray[0] = nums[0]
        curr = 1
        for i in range(1, len(nums)):
            if nums[i] > sortedArray[curr-1]:
                sortedArray[curr] = nums[i]
                curr += 1
            else:
                ind = self.binarySearch(sortedArray, 0, curr-1, nums[i])
                sortedArray[ind] = nums[i]

        return curr

#         DP: TC - O(n^2), SC - O(n)
#         dp = [1 for _ in range(len(nums))]
#         result = 1
#         for i in range(1, len(nums)):
#             for j in range(i):
#                 if nums[i] > nums[j]:
#                     dp[i] = max(dp[j]+1, dp[i])
#                     result = max(result, dp[i])

#         return result
