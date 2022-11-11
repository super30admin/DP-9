#Time: O(n^2)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x:(x[0], x[1]))
        
        n = len(envelopes)
        dp = [1] * n
        res = 1
        for i in range(1, n):
            for j in range(i):
                if (envelopes[i][1] > envelopes[j][1] and 
                    envelopes[i][0] != envelopes[j][0]):
                    dp[i] = max(dp[i], dp[j] + 1)
                    res = max(dp[i], res)
        
        return res
        
        