# The maxEnvelopes method finds the maximum number of envelopes that can be Russian-dolled (nested).

# Approach:
# - Sort envelopes by width in ascending order and height in descending order for the same width.
# - Use a dynamic programming array (`dp`) to track the heights of the longest increasing subsequence (LIS).
# - For each envelope's height, use binary search to find its position in `dp`:
#   - Replace the existing height or extend the LIS.

# TC: O(n log n) - Sorting envelopes and binary search for each height.
# SC: O(n) - Space for the `dp` array.


from typing import List


class Solution:
  def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
    envelopes.sort(key=lambda x: (x[0], -x[1]))
    ans = 0
    dp = [0] * len(envelopes)

    for _, h in envelopes:
      l = 0
      r = ans
      while l < r:
        m = (l + r) // 2
        if dp[m] >= h:
          r = m
        else:
          l = m + 1
      dp[l] = h
      if l == ans:
        ans += 1

    return ans