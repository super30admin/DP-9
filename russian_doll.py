# // Time Complexity :O(n^2)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no, but giving time limit exceeded for sec last solution, when i ran that test case separately it is working though


# // Your code here along with comments explaining your approach

#0(n2),0(n)
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes=sorted(envelopes,key=lambda x:x[0])
        dp=[1 for i in range(len(envelopes))]
        maxx=1
        for i in range(len(envelopes)):
            for j in range(0,i):
                if envelopes[i][1]>envelopes[j][1] and envelopes[i][0]>envelopes[j][0]:
                    dp[i]=max(dp[i],dp[j]+1)
                    maxx=max(maxx,dp[i])
        return maxx