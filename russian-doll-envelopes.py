# Time O(n log n)
# Space O(n)
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        effectiveIncreasingOrder = [envelopes[0][1]]
        n = len(envelopes)
        for i in range(1, n):
            if envelopes[i][1] > effectiveIncreasingOrder[-1]:
                effectiveIncreasingOrder.append(envelopes[i][1])
            else:
                #find num just above nums[i] using Binary Search
                idx = self.findIndex(effectiveIncreasingOrder, envelopes[i][1])
                effectiveIncreasingOrder[idx] = envelopes[i][1]
        return len(effectiveIncreasingOrder)
    
    def findIndex(self, arr, target):
        low = 0
        high = len(arr) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return low
