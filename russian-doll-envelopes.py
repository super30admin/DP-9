'''

TC: O(n^2)
SC: O(n)

'''
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        elen = len(envelopes)
        
        if not elen:
            return 0
        
        elist = sorted(envelopes, key = lambda k : (k[0], k[1]))
        dp = [1 for _ in envelopes]
        
        for i in range(1, elen):
            maxm = 0
            for j in range(i+1):
                if elist[i][1] > elist[j][1] and elist[i][0] > elist[j][0]:
                    maxm = max(maxm, dp[j])
            dp[i] += maxm
        
        return max(dp)
                
        
        
        