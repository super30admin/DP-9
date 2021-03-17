#TC: O(nlogn)
#SC: O(N)

class Solution(object):
    def maxEnvelopes(self, envelopes):
        envelopes.sort(key = lambda a: (a[0], -a[1]))
        
        dp = []
        
        for w, h in envelopes:
            index = bisect_left(dp, h)
            
            if index == len(dp):
                dp.append(h)
            else:
                dp[index] = h
        
        return len(dp)