# Time Complexity: O(n log n)
# Space Complexity: O(n)

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0

        # Sort by height ascending, and by width descending for equal heights
        envelopes.sort(key=lambda x: (x[1], -x[0]))

        # Extract widths for LIS
        widths = [w for w, h in envelopes]
        lis = []

        for w in widths:
            idx = self.binarySearch(lis, w)
            if idx == len(lis):
                lis.append(w)
            else:
                lis[idx] = w

        return len(lis)

    def binarySearch(self, arr: List[int], target: int) -> int:
        low, high = 0, len(arr) - 1
        while low <= high:
            mid = (low + high) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return low
