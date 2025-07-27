"""
I implemented a solution to find the maximum number of envelopes that can be Russian-dolled (nested). I first sorted the envelopes by height in ascending order and width in descending order to handle duplicates. Then I used a variation of the Longest Increasing Subsequence (LIS) on the widths using binary search. If the current width is larger than the last in the sequence, I extend the sequence. Otherwise, I replace the correct position to keep the sequence optimized for further growth.
Time Complexity: O(nlogn)
Space Complexity: O(n)
"""
class Solution:
    def maxEnvelopes(self, envelopes):
        envelopes.sort(key=lambda x: (x[1], -x[0]))
        n = len(envelopes)
        arr = [0] * n
        arr[0] = envelopes[0][0]
        length = 1

        for i in range(1, n):
            if envelopes[i][0] > arr[length - 1]:
                arr[length] = envelopes[i][0]
                length += 1
            else:
                bsIdx = self.binarySearch(arr, 0, length - 1, envelopes[i][0])
                arr[bsIdx] = envelopes[i][0]

        return length

    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                return mid
            if arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low