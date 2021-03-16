class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        #Approach: Dynamic Programming
        #Time Complexity: O(m * n)
        #Space Complexity: O(m * n)
        #where, m and n are the greatest width and height in the envelopes array, respectively
        
        eSet = set()
        m = n = 0
        for e in envelopes:
            eSet.add((e[0], e[1]))
            m = max(m, e[0])
            n = max(n, e[1])
            
        dp = [[0 for j in range(n + 1)] for i in range(m + 1)]
        
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if (i, j) in eSet:
                    dp[i][j] = 1 + dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                    
        return dp[-1][-1]