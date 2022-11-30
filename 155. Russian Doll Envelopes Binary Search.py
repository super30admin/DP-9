class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if envelopes is None or len(envelopes) == 0:
            return 0

        n = len(envelopes)

        envelopes.sort(key=lambda x: (x[0], -x[1]))  # sort envelopes according to width
        arr = [envelopes[0]]
        l = 1

        for i in range(1, n):
            if envelopes[i][1] > arr[l - 1][1] and envelopes[i][0] > arr[l - 1][0]:
                arr.append(envelopes[i])
                l += 1
            else:
                bsIndex = self.binarySearch(arr, envelopes[i], 0, l - 1)
                # print(bsIndex, arr, len(arr))
                arr[bsIndex] = envelopes[i]
        # print(envelopes)
        # print(arr)
        return l

    def binarySearch(self, arr, target, low, high):
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid][1] == target[1]:
                return mid
            elif arr[mid][1] > target[1]:
                high = mid - 1
            else:
                low = mid + 1
        return low
# binary Search
# Time Complexity: O(nlogn)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
