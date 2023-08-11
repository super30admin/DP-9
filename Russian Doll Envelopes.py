# Time Complexity : O(n log n)
# Space Complexity : O(n) to maintain the array
# Code ran on LeetCode
# Sort the envelopes based on height, if heights are same, sort them in decreasing order of width. Maintain an array to store the length of the longest increasing sub sequence of widths. If we get an element that is greater than the last element in the array, append it to the list. If not, use binary search to get the element that is just greater than the current element and replace it with the current element. The length of the array gives the answer.

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes = sorted(envelopes, key=lambda x: (x[0], -1*x[1]))
        n = len(envelopes)
        arr = [0]*n
        arr[0] = envelopes[0][1]
        le = 1
        def binarySearch(arr, low, high, target):
            while low <= high:
                mid = low + (high - low)//2
                if arr[mid] == target:
                    return mid
                elif arr[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return low

        for i in range(1, n):
            if envelopes[i][1] > arr[le-1]:
                arr[le] = envelopes[i][1]
                le+=1
            else:
                bsIdx = binarySearch(arr, 0, le-1, envelopes[i][1])
                arr[bsIdx] = envelopes[i][1]

        return le

        