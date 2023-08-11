# Time Complexity : O(n log n)
# Space Complexity : O(n) to maintain the array
# Code ran on LeetCode
# Maintain an array to store the length of the longest increasing sub sequence. If we get an element that is greater than the last element in the array, append it to the list. If not, use binary search to get the element that is just greater than the current element and replace it with the current element. The length of the array gives the answer.

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # n = len(nums)
        # dp = [1]*n
        # res = 1

        # for i in range(1, n):
        #     for j in range(i):
        #         if nums[j] < nums[i]:
        #             dp[i] = max(dp[i], 1 + dp[j])
        #             res = max(res, dp[i])
        # return res

        # Binary Search
        n = len(nums)
        arr = [0]*n; le = 1; arr[0] = nums[0]

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
            if nums[i] > arr[le-1]:
                arr[le] = nums[i]
                le+=1
            else:
                bsIdx = binarySearch(arr, 0, le-1, nums[i])
                arr[bsIdx] = nums[i]
        return le