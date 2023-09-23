# Time Complexity: O(sort)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        envelopes.sort(key = lambda x: (x[0], -x[1]))
        ans = 0
        dp = [0] * len(envelopes)
        for _, h in envelopes:
            l = 0
            r = ans
            while (l < r):
                m = ((l + r) // 2)
                if (dp[m] >= h):
                    r = m
                else:
                    l = (m + 1)
            dp[l] = h
            if l == ans:
                ans += 1
        return ans