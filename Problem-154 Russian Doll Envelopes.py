# 354. Russian Doll Envelopes
# https://leetcode.com/problems/russian-doll-envelopes/

# Logic: Sort the input and apply LIS.

# Time Complexity: O(n*n)
# Space Complexity: O(n)

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x:(x[0], -x[1]))
        
        n = len(envelopes)
        dp = [1 for i in range(n)]
        
        max_val = 1
        for i in range(1, n):
            for j in range(i):
                if envelopes[j][0] < envelopes[i][0] and envelopes[j][1] < envelopes[i][1]:
                    dp[i] = max(dp[j]+1, dp[i])
                    max_val = max(max_val, dp[i])
        return max_val