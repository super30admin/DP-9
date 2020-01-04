'''
Leetcode- 354. Russian Doll Envelopes - Time limit exceeded
time complexity - O(N2)
space complexity -O(N)
Approach - DP

'''
class Solution:
    retval=1
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if len(envelopes)==0: return 0
        envelopes.sort(key=lambda x:x[0])
    
        
        dp =[1 for _ in range(len(envelopes))]
        for i in range(1,len(envelopes)):
            maxsub=0
            for j in range(i):
                if envelopes[i][0]>envelopes[j][0] and envelopes[i][1]>envelopes[j][1]:
                    maxsub=max(maxsub,dp[j])
            dp[i]=dp[i]+maxsub
            self.retval=max(self.retval,dp[i])
                    
            
        return self.retval
        
        
        