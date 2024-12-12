"""
This cannot be solved with the 2 for loops. Will have the same problem as the longest increasing subsequence.
Thus, we could use the exhaustive approach.

Appraoch2 DP tabulation: sort the array based on either length or breadth.
The problem is: find the longest increasing subsequnce based on the heights. However, when the heigths are same in the
case reverse sort since [(1,2), (2,2), (2,3), (3,4), (3,5), (4,4)], ans: (1,2) then (2,3) then which one pick ?
since (3,4), (3,5) have the same width. Out of them, one could be used in such as reverse sort based on the width.
Thus the array is [(1,2), (2,2), (2,3), (3,5), (3,4), (4,4)] now ans: (1,2) then (2,3) then  (3,5)
"""


class Solution:
    def binarySearch(self, lo, hi, target, arr):
        while (lo <= hi):
            mid = lo + (hi - lo) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                hi = mid - 1

            elif arr[mid] < target:
                lo = mid + 1

        return lo

    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        # increasing on height and decreasing on width
        envelopes = sorted(envelopes, key=lambda x: (x[1], -x[0]))

        arr = []
        # put the width in effective array
        arr.append(envelopes[0][0])

        for idx in range(1, len(envelopes)):
            if envelopes[idx][0] > arr[-1]:
                arr.append(envelopes[idx][0])
            else:
                newidx = self.binarySearch(0, len(arr) - 1, envelopes[idx][0], arr)
                arr[newidx] = envelopes[idx][0]

        return len(arr)


