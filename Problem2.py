# Time Complexity : O(n**2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# sort wrt to height then the question basically is longest increasing subsequence
class Solution:
    def __sortFunc(self,a):
        return a[0]
    
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        if envelopes == None:
            return 0
        
        envelopes = sorted(envelopes, key= self.__sortFunc)
        
        
        dp = [1]*len(envelopes)
        maxNum = 1
        for i in range(1,len(envelopes)):
            for j in range(0,i):
                
                if envelopes[j][1] < envelopes[i][1] and envelopes[j][0] < envelopes[i][0]:
                    
                    dp[i] = max(dp[i],dp[j]+1)
                    maxNum = max(maxNum,dp[i])
        
        return maxNum
        
        