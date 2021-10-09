"""
Time Complexity : O(nlogn) where n is the no. of envelopes
Space Complexity : O(n) where n is the no. of envelopes
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if len(envelopes) == 0:
            return 0
        n = len(envelopes)
        dp = [1 for i in range(len(envelopes))]
        # First we sort the elements
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        # We traverse through the envelopes and then we check if the elements of 
        # first envelope are smaller than the next envelope. If they are we increment           # the index in dp array by one and take which ever is maximum from current 
        # index and older maximum. We then return maximum
        for i in range(1, n):
            for j in range(i):
                if envelopes[i][1] > envelopes[j][1]:
                    dp[i] = max(dp[i], 1 + dp[j])
        return max(dp)