# Time is O(n^2) as we have to loop through the envelopes twice to determine which dolls can fit.
# Space is O(1)

# The intuition is same as longest increasing subsequence, where we to first sort it either by width or height and if width is same then inverse the sorting of height.

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[1], -x[0]))
        n = len(envelopes)
        dp = [1] * (n)
        for i in range(1, n):
            for j in range(0, i):
                if envelopes[i][0] > envelopes[j][0]:
                    dp[i] = max(dp[i], 1 + dp[j])

        return max(dp)

# Then similar to LIS problem, we can use binary search to determine the effective increasing subsequence and return that as the value.
# The imt complexity is O(nlogn)
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[1], -x[0]))
        n = len(envelopes)
        arr = []
        arr.append(envelopes[0][0])
        for i in range(n):
            if envelopes[i][0] > arr[-1]:
                arr.append(envelopes[i][0])
            else:
                bsIdx = self.binarySearch(arr, envelopes[i][0])
                arr[bsIdx] = envelopes[i][0]

        return len(arr)

    def binarySearch(self, arr, target):
        low = 0
        high = len(arr) - 1
        while low < high:
            mid = low + (high - low) // 2

            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid
            else:
                low = mid + 1

        return low

