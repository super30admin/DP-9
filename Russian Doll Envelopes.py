""""// Time Complexity : O(n log(n))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class customSort:
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def __lt__(self, other):
        if self.width == other.width:
            return self.height > other.height
        return self.width < other.width


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        for i in range(len(envelopes)):
            temp = customSort(envelopes[i][0], envelopes[i][1])
            envelopes[i] = temp
        envelopes.sort()
        n = len(envelopes)
        arr = [0] * n
        arr[0] = envelopes[0].height
        length = 1
        for i in range(1, n):
            if envelopes[i].height > arr[length - 1]:
                arr[length] = envelopes[i].height
                length += 1
            else:
                bsIdx = self.binarySearch(arr, 0, length - 1, envelopes[i].height)
                arr[bsIdx] = envelopes[i].height

        return length

    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2

            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return low


""""// Time Complexity : O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# TLE
# class Solution:
#     def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
#         envelopes.sort(key= lambda x: [x[0], -x[1]])
#         if len(envelopes) == 1:
#             return 1
#         n=len(envelopes)
#         dp=[1]*n
#         maxi=1
#         for i in range(1, n):
#             for j in range(0, i):
#                 if envelopes[j][0] < envelopes[i][0] and envelopes[j][1] < envelopes[i][1]:
#                     dp[i] = max(dp[i], dp[j]+1)
#                     maxi=max(maxi, dp[i])
#         return maxi


