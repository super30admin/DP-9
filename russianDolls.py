class Solution(object):
    def maxEnvelopes(self, envelopes):
        
        envelopes.sort(key=lambda x: (x[0],-x[1]))
        dp = [1 for i in range(0,len(envelopes))]
        max1 = 1
        for i in range(1,len(envelopes)):
            for j in range(0,i):
                if(envelopes[j][0]<envelopes[i][0] and envelopes[j][1]<envelopes[i][1] and dp[i]<1+dp[j]):
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)