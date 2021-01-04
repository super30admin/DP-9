#Time: O(n^2)
#Space: O(N)
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:

        if envelopes == None or len(envelopes)==0:
            return 0

        dp=[1]*len(envelopes)
        envelopes = sorted(envelopes, key = lambda x:x[0])

        for i in range(1, len(envelopes)):
            for j in range(i):
                if envelopes[i][1]> envelopes[j][1] and envelopes[i][0] != envelopes[j][0]:
                    dp[i]= max(dp[i], dp[j]+1)

        return max(dp)
