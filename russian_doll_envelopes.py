# Time Complexity: O(nlogn)
# Space Complexity: O(n)
from bisect import bisect_left
from typing import List


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:

        n = len(envelopes)
        envelopes.sort(key=lambda x: (x[0], -x[1]))

        dp = []

        for w, h in envelopes:
            curr_left = bisect_left(dp, h)

            if curr_left == len(dp):
                dp.append(h)
            else:
                dp[curr_left] = h

        return len(dp)