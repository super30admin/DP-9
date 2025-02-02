"""
TC: O(n logn) n- number of envelopes
SP: O (n)
similar approach to logest subsequence, sort the envelops by height and then width, find longest subsequence using width
"""

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key = lambda x: (x[1], -x[0]))
        widths = [w for w, _ in envelopes]
        arr = [widths[0]]
        ln = 1
        for i in range(1, len(widths)):
            just_greater_idx = bisect.bisect_left(arr, widths[i])
            if just_greater_idx == ln:
                arr.append(widths[i])
                ln += 1
            else:
                arr[just_greater_idx] = widths[i]
        return ln
        