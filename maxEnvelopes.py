"""
Time limit exceed for DP solution 

-similar to the longest increasing subsequence problem. 
- sort the envelopes array in increasing order of first index and decreasing order of second index and same as longest increasing subsequence problem 

"""

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        envelopes.sort(key=lambda x:x[1])
        
        max1=1
        
        dp=[1]*len(envelopes)
        for i in range(len(dp)):
            for j in range(i):
                if(envelopes[j][0] < envelopes[i][0] and envelopes[j][1] < envelopes[i][1]):
                    dp[i]=max(dp[i],dp[j]+1)
                    max1=max(max1,dp[i])
        return max1
        