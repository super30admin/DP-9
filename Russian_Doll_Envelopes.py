# Approach:
# This problem can be reduced to finding the longest increasing subsequence (LIS) in a sorted array of envelopes.
# We first sort the envelopes by their width in ascending order. If two envelopes have the same width, we sort them by height in descending order.
# The reason for sorting by height in descending order for envelopes with the same width is to ensure that we don't mistakenly include envelopes of the same width in our LIS.
# After sorting, we can use a technique similar to solving the LIS problem to find the maximum number of envelopes that can Russian doll inside each other.
# Time Complexity: O(n log n), where n is the number of envelopes. Sorting takes O(n log n), and the LIS part takes O(n log n) as well.
# Space Complexity: O(n), for storing the list of envelopes and the dynamic programming array used for LIS calculation.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        # Step 1: Sort the envelopes
        # Sort by width in ascending order, and by height in descending order if widths are the same
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        
        # Step 2: Extract the heights and find LIS
        # After sorting, we just need to find the LIS in the height dimension (i.e., find LIS in the second element of each envelope)
        heights = [h for _, h in envelopes]
        
        # Step 3: Use binary search to find LIS efficiently
        # 'tails' will store the smallest tail element for all increasing subsequences of different lengths
        tails = []
        
        for height in heights:
            # Perform binary search to find the position to replace or append
            pos = bisect.bisect_left(tails, height)
            
            if pos == len(tails):
                tails.append(height)
            else:
                tails[pos] = height
        
        # The length of 'tails' will give us the length of the LIS
        return len(tails)
