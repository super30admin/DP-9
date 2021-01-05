#Time Complexity : O(nlogn) where n is the length of the input array
#Space Complexity : O(n) 
#Did this code successfully run on Leetcode : Yes

class Solution:
    def binarySearch(self, arr, l, h, target):
        while l <= h:
            m = l + (h-l)//2
            if arr[m][1] == target:
                return m
            elif arr[m][1] > target:
                h = m - 1
            else:
                l = m + 1
        return l

    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0

        envelopes.sort(key = lambda x: (x[0], -x[1]))
        sortedArray = [0 for _ in range(len(envelopes))]
        sortedArray[0] = envelopes[0]
        curr = 1

        for i in range(1, len(envelopes)):
            if envelopes[i][1] > sortedArray[curr-1][1]:
                sortedArray[curr] = envelopes[i]
                curr += 1
            else:
                ind = self.binarySearch(sortedArray, 0, curr-1, envelopes[i][1])
                sortedArray[ind] = envelopes[i]

        return curr

#         DP : TC - O(n^2), SC - O(n)
#         dp = [1 for _ in range(len(envelopes))]
#         result = 1
#         for i in range(1, len(envelopes)):
#             for j in range(i):
#                 if envelopes[j][0] != envelopes[i][0] and envelopes[j][1] < envelopes[i][1]:
#                     dp[i] = max(dp[j]+1, dp[i])
#                     result = max(result, dp[i])

#         return result
