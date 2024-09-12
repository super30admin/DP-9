# // Time Complexity :O(nlogn)
# // Space Complexity :O(1)
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x:(x[0],-x[1]))
        print(envelopes)
        dp=[0 for i in range(len(envelopes))]
        maxlen=0
        dp.append(envelopes[0])
        
        for i in range(len(envelopes)):
            pos=self.bsearch(envelopes[i][1],dp,maxlen)
            dp[pos]=envelopes[i]
        
            if pos==maxlen:
                maxlen+=1
                
                        
                
        
        return maxlen
    def bsearch(self,target,dp,h):
        l=0
        
        while l<h:
            mid=(l+h)//2
            if target==dp[mid][1]:
                return mid
            elif target>dp[mid][1]:
                l=mid+1
            else:
                h=mid
        print("val",l)
        return l
    