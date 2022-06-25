class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes or len(envelopes)==0 or len(envelopes[0])==0:
            return 0
        result=1
        envelopes=sorted(envelopes, key=lambda x:x[0])
        print(len(envelopes))
        dp=[1 for i in range(len(envelopes))]
        for i in range(len(dp)):
            for j in range(i):
                if envelopes[j][0]<envelopes[i][0] and envelopes[j][1]<envelopes[i][1]:
                    dp[i]=max(dp[i],dp[j]+1)
            
            result=max(result,dp[i])
        return result
                
            