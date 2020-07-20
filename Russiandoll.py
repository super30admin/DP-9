#Time Complexity : O(N*N) + O(NLogN) where N is number of elemetns is envelope 
#Space Complexity : O(N) where N is numer of elemetns in envelope
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if len(envelopes) == 0 or envelopes == None:
            return 0
        max1 = 1
        dp = [1 for x in range(len(envelopes))]
        envelopes.sort(key= lambda x: (x[0]))
        for i in range(1,len(dp)):
            for j in range(i):
                if envelopes[j][1] < envelopes[i][1] and  envelopes[j][0] < envelopes[i][0] :
                    dp[i] = max(dp[i],dp[j]+1)
                    max1 = max(max1,dp[i])
        return max1