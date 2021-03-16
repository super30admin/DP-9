# Appproach - Use DP approach similar to LIS problem
# key - sort one dimension only
# Time Complexity - O(N^2) - TLE
# Space - O(N)

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        if not envelopes or len(envelopes) == 0:
            return 0
        
        # sort array with one dimension (sorted)
        envelopes.sort(key = lambda x: (x[0], x[1]))
        
        dp = [1] * len(envelopes)
        max_len = 1
        
        for i in range(1, len(envelopes)):
            for j in range(0, i):
                if envelopes[i][0] > envelopes[j][0] and envelopes[i][1] > envelopes[j][1]: # both have to be true in order to fit the dolls
                    dp[i] = max(dp[i], dp[j] + 1)
                    max_len = max(max_len, dp[i])
                    
        return max_len


# Binary Search Approach
        