#As taught in class, using DP to solve thus problem (sort and find increasing subsequence)
#Time complexity: O(n^2)
#Space complexity: O(n)
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if len(envelopes)==0 or envelopes is None:
            return 0
        arr = sorted(envelopes,key = lambda x: x[1])
        dp = [1]*len(envelopes)
        m = 1
        for i in range(1,len(dp)):
            for j in range(i):
                if arr[j][0] < arr[i][0] and arr[j][1] < arr[i][1]:
                    dp[i] = max(dp[i],dp[j]+1)
                    m = max(m,dp[i])
        return m
        