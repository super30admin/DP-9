"""
time - o(n^2)
space - o(n)
"""
class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        if not envelopes:
            return 0
        
        dp = [1] * len(envelopes) 
        
        envelopes = sorted(envelopes, key = lambda x:x[0]) #sort the values according to one of the dimensions
        
        #print(envelopes)
        
        for i in range(1, len(envelopes)): #find the longest subsequence that can be formed by the other dimension
            for j in range(i):
                
                if envelopes[j][1] < envelopes[i][1] and envelopes[j][0] != envelopes[i][0] : #dont consider the ones whose even one of the dimensions is same
                    dp[i] = max(dp[i], dp[j] + 1)
                    
        return max(dp)