# Time complexity : O(n*n)
# Space complexity : O(n)
# Leetcode : Time limit exceeded

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        # sort the envelopes list in asc for first element and desc for the other
        envelopes.sort(key = lambda x: [x[0],-x[1]])
        n = len(envelopes)
        
        # create an empty dp array
        dp = [1]*n
        
        # traverse over all the possible combinations
        for i in range(1,n):
            for j in range(i):
                # if any 2nd value of i index is greater than j index
                if envelopes[j][1] < envelopes[i][1]:
                    # update the dp of ith index with the max of current index and the jth index + 1
                    dp[i] = max(dp[i], dp[j]+1)
        
        # return max of all the values in dp array
        return max(dp)
