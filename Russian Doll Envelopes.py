#time: O(n^2)
#space:  O(n)

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        env=sorted(envelopes,key=lambda x:(x[0]))
        dp=[1]*len(env)
        maxval=1
        for i in range(1,len(env)):
            for j in range(0,i):
                if(env[j][0]<env[i][0] and env[j][1]<env[i][1]):
                    dp[i]=max(dp[i],dp[j]+1)
                    maxval=max(maxval,dp[i])
        return maxval