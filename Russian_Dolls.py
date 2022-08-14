# Time Complexity : O(n*log(n))
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

# binary-search
class Solution:
    def binarySearch(self, result, target):
        start = 0
        end = len(result) - 1
        while start <= end:
            mid = start + (end - start) // 2
            if result[mid][1] == target:
                return mid
            elif mid >= 0 and result[mid][1] > target:
                end = mid - 1
            elif mid < len(result) and result[mid][1] <= target:
                start = mid + 1
        return start if 0 <= start < len(result) else -1

    def maxEnvelopes(self, envelopes: list[list[int]]) -> int:
        envelopes.sort(key= lambda x: [x[0], -x[1]])
        if len(envelopes) == 1:
            return 1
        result = [envelopes[0]]
        for i in range(1, len(envelopes)):
            if len(result) == 1 and envelopes[i][1] <= result[-1][1]:
                result = [envelopes[i]]
            elif envelopes[i][1] > result[-1][1]:
                result.append(envelopes[i])
            else:
                index = self.binarySearch(result, envelopes[i][1])
                if index != -1:
                    result[index] = envelopes[i]
        return len(result)


print(Solution().maxEnvelopes([[5, 4], [6, 4], [6, 7], [2, 3]]))

# TLE.
# using custom sort.
# TC: O(n^2); SC: O(n)
# from functools import cmp_to_key
#
#
# class Solution:
#     def maxEnvelopes(self, envelopes: list[list[int]]) -> int:
#         def customSort(a, b):
#             if b[0] < a[0]:
#                 return 1
#             elif a[0] == b[0]:
#                 if a[1] > b[1]:
#                     return -1
#                 else:
#                     return 1
#             else:
#                 return -1
#         envelopes.sort(key=cmp_to_key(customSort))
#         dp = [1]*len(envelopes)
#         for i in range(1, len(envelopes)):
#             for j in range(i):
#                 if envelopes[j][1] < envelopes[i][1]:
#                     dp[i] = max(dp[j]+1, dp[i])
#         return max(dp)
#
#
# print(Solution().maxEnvelopes([[5, 4], [6, 4], [6, 7], [2, 3]]))


# TLE.
# using custom sort.
# TC: O(n^2); SC: O(n)
# class customSort:
#     def __init__(self, width, height):
#         self.width = width
#         self.height = height
#
#     def __lt__(self, other):
#         if self.width == other.width:
#             return self.height > other.height
#         return self.width < other.width
#
#
# class Solution:
#     def maxEnvelopes(self, envelopes: list[list[int]]) -> int:
#         for i in range(len(envelopes)):
#             cs = customSort(envelopes[i][0], envelopes[i][1])
#             envelopes[i] = cs
#         envelopes.sort()
#         dp = [1]*len(envelopes)
#         for i in range(1, len(envelopes)):
#             for j in range(i):
#                 if envelopes[j].height < envelopes[i].height:
#                     dp[i] = max(dp[j]+1, dp[i])
#         return max(dp)
#
#
# print(Solution().maxEnvelopes([[5, 4], [6, 4], [6, 7], [2, 3]]))


# TLE.
# TC:- O(n^2); SC: O(n)
# class Solution:
#     def maxEnvelopes(self, envelopes: list[list[int]]) -> int:
#         envelopes.sort(key=lambda x: x[0])
#         dp = [1] * len(envelopes)
#         for i in range(1, len(envelopes)):
#             for j in range(0, i):
#                 if envelopes[i][1] > envelopes[j][1] and envelopes[i][0] != envelopes[j][0]:
#                     dp[i] = max(dp[j] + 1, dp[i])
#         return max(dp)
#
#
# print(Solution().maxEnvelopes([[5, 4], [6, 4], [6, 7], [2, 3]]))




