# Time Complexity : O(N^2 log N) as we are iterating through the logs list once
# Space Complexity : O(N) as we are using extra space to store the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Your code here along with comments explaining your approach:
# I am sorting the envelopes based on width in ascending order and height in descending order.
# This way, when we apply the longest increasing subsequence (LIS) algorithm on the heights,
# we ensure that we do not count envelopes with the same width.
# I then use a dynamic programming approach with binary search to find the length of the longest increasing subsequence of heights.
# I maintain a list 'result' which will store the smallest tail of all increasing subsequences
# with different lengths found so far. For each height in the sorted envelopes, I use binary search to find its position in 'result'.
# If the height is larger than  all elements in 'result', it is appended to 'result'. Otherwise, it replaces the first element in 'result'
# which is greater than or equal to it. The length of 'result' at the end will be the maximum number of envelopes that can be Russian dolled.

from typing import List 
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        result = []
        n = len(envelopes)
        for i in envelopes:
            low = 0
            high = len(result)-1
            while low <= high:
                mid = low + (high - low) // 2
                if result[mid] < i[1] :
                    low = mid + 1
                else:
                    high = mid - 1
            if len(result) == low:
                result.append(i[1])
            else:
                result[low] = i[1]
            # print(result)
        return len(result)

            
            
                