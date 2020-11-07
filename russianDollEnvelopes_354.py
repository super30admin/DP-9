# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : No, TLE encountered
# Any problem you faced while coding this : No

# Approach:
# When we sort based on w or h, we can do LIS on the other parameter. 
# 1. Sort based on width. 2. Update dp array for height like LIS. Before updating the dp array: check if width is greater than previous width: only then update it. If width is equal, don't increment the value and move to next i and reset j. 3. return max from the dp array.

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        if envelopes == None or len(envelopes)==0:
            return 0
        
        dp=[1]*len(envelopes)
        envelopes = sorted(envelopes, key = lambda x:x[0])
        
        for i in range(1, len(envelopes)):
            for j in range(i):
                if envelopes[i][1]> envelopes[j][1] and envelopes[i][0] != envelopes[j][0]:
                    dp[i]= max(dp[i], dp[j]+1)
                    
        return max(dp)
        