class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        if not envelopes:
            return 0
        n = len(envelopes)
        envelopes = sorted(envelopes,key=lambda x: (x[0], -x[1]))
        dp = [0]* n
        dp[0] = envelopes[0][1]
        idx = 1     
        print(envelopes)
        #print(dp)
        for i in range(1, len(envelopes)):
            if envelopes[i][1] > dp[idx -1 ]:
                dp[idx] = envelopes[i][1]
                idx += 1
            else:
                replace_idx = self.binarysearch(dp,envelopes[i][1],0,idx -1)
                dp[replace_idx] = envelopes[i][1]        
        print(dp)
        return idx
    
    
    def binarysearch(self,dp,val,low,high):
        
        while low <= high:
            mid = low + (high - low) //2
            if dp[mid] == val:
                return mid            
            elif dp[mid] < val:
                low = mid +1
            else:
                high = mid -1
        
        return low
            
