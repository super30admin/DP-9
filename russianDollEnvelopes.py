"""
DP Approach -  same as 300. Longest Increasing subsequence
TC - O(n^2) i.e. O(n log n) + O(n^2), sine higher order term is O(n^2) so TC = O(n^2)
SC - O(n)

Binary Search Approach -- same as 300. Longest Increasing subsequence
TC - O(n log n)
SC - O(n)
"""
class Solution:
    def binarySearch(self, dp, low, high, target):
        while low <= high:
            mid = low + (high-low)//2
            if dp[mid] == target: return mid
            elif target < dp[mid]: high = mid - 1
            else: low = mid + 1
        return low

    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if envelopes is None or len(envelopes) == 0: return 0

        n = len(envelopes)
        dp = [0 for i in range(n)]

        # sort by width in ascending order
        envelopes.sort(key=lambda x: (x[0], -x[1]))

        # add height of 0th list to dp[0]
        dp[0] = envelopes[0][1]
        arrLen = 1

        # start i from 1st element and compare it with 0th element (j)
        for i in range(1, n):
            # eg. compare 0th element of dp[0] with envelopes[i][1]
            if envelopes[i][1] > dp[arrLen - 1]:
                dp[arrLen] = envelopes[i][1]
                arrLen += 1
            else:
                index = self.binarySearch(dp, 0, arrLen-1, envelopes[i][1])
                dp[index] = envelopes[i][1]

        return arrLen