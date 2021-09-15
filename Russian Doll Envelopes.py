class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if envelopes == None or len(envelopes) == 0:
            return 0
        dp = [1 for i in range(len(envelopes))]
        max_val = 1

        envelopes.sort(key=lambda x: (x[0], -x[1]))

        for i in range(1, len(dp)):
            for j in range(i):
                if envelopes[i][1] > envelopes[j][1] and envelopes[i][0] > envelopes[j][0]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    max_val = max(max_val, dp[i])
        return max_val
