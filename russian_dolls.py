'''
Time Complexity : O(nlogn) in worst case run Binary search for all elements in the nums list
Space Complexity : O(n) store elements in arr
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Approach: First step is to sort the envelopes array in increasing order of first index and decreasing order of last index.
Next is similar as longest increasing subsequence problem.
'''

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        length = len(envelopes)
        arr = []
        arr.append(envelopes[0][1])
        for i in range(1, length):
            if envelopes[i][1] > arr[-1]:
                arr.append(envelopes[i][1])
            else:
                position = self.binarySearch(arr, 0, len(arr)-1, envelopes[i][1])
                arr[position] = envelopes[i][1]
        return len(arr)

    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = (low+high)//2
            if arr[mid] == target:
                return mid
            if arr[mid] > target:
                high = mid-1
            else:
                low = mid+1
        return low
