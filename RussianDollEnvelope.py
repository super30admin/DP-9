# Time Complexity: O(n^2)
# Space Complexity: O(n)
# DP Approach
# class Solution:
#     def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
#         n = len(envelopes)
#         envelopes.sort(key=lambda x: (x[0], -x[1]))
#         dp = [1] * n
#         result = 1

#         for i in range(1, n):
#             for j in range(i):
#                 if envelopes[j][1] < envelopes[i][1]:
#                     dp[i] = max(dp[i], dp[j] + 1)
#                     result = max(result, dp[i])

#         return result

# Time Complexity: O(nlogn)
# Space Complexity: O(n)
# LIS Approach
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
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