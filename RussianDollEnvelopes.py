# Time Complexity : O(NlogN)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using DP Approach. Same as Longest Increasing Subsequence
# Just we need to sort first on width in ascending order and then on height in descending order to have only increasing elements


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        envelopes.sort(key=lambda x: (x[0], -x[1]))

        arr = [envelopes[0][1]]
        length = 1
        for i in range(1, len(envelopes)):
            if envelopes[i][1] > arr[-1]:
                arr.append(envelopes[i][1])
                length += 1
            else:
                bstIndex = self.binarySearch(arr, envelopes[i][1], 0,
                                             len(arr) - 1)
                arr[bstIndex] = envelopes[i][1]
        return length

    def binarySearch(self, arr, target, left, right):
        while left <= right:
            mid = left + (right - left) // 2
            if arr[mid] > target:
                right = mid - 1
            elif arr[mid] < target:
                left = mid + 1
            else:
                return mid
        return left
