# Time: O(nlogn), logn for searching the position for the element's and there are n steps.
# Space: O(n)
# runs on leetcode : YES
# any problems faced : NO
#bisect is python library to maintain sorted order of the array in python
# basically the same pattern

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        inf = 0x3f3f3f3f
        #special number and large enough for most cases 
        
        # sort by increasing width, decreasing height
        envelopes = sorted(envelopes, key = lambda x: (x[0], -x[1]))
        dp = [inf] * len(envelopes)               # store heights O(n) space
        lo, hi = 0, 0
        
        # find LIS of heights
        # O(n)
        for _, height in envelopes:
            # find left most insertion point
            # O(log n)
            left = bisect_left(dp, height, lo, hi)
            dp[left] = height
            if dp[hi] == height:
                hi += 1
                
        return hi # same thing as bisect.bisect_right(dp, inf - 1))