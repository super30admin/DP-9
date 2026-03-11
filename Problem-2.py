# Time Complexity : O(N log N)  # Sorting + LIS with binary search
# Space Complexity : O(N)      # LIS array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Sort envelopes by width ascending and height descending to avoid invalid nesting.
# Extract heights and apply Longest Increasing Subsequence on heights.
# The LIS length represents the maximum number of envelopes that can be nested.

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        import bisect
        
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        
        lis = []
        
        for _,h in envelopes:
            pos = bisect.bisect_left(lis, h)
            
            if pos == len(lis):
                lis.append(h)
            else:
                lis[pos] = h
        
        return len(lis)