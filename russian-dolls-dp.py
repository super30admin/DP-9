# DP Approach
# Time Complexity: O(n log n) + O(n^2)
# Space Complexity: O(n)
class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        # Edge Case
        if not envelopes:
            return 0
        
        # Sort the input array by index 0
        envelopes.sort(key = lambda x:x[0])
        
        # Initialize dp array - dp[i] - longest increasing subsequence at i
        dp = [1 for _ in range(len(envelopes))]
        maxlen = 1
        
        for i in range(1, len(envelopes)):
            for j in range(0, i):
                if envelopes[j][1] < envelopes[i][1] and envelopes[j][0] != envelopes[i][0]:
                    dp[i] = max(dp[i], dp[j]+1)
                    maxlen = max(maxlen, dp[i])
                    
        return maxlen