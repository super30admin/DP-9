"""
Time Complexity : O(nlogn) where n is the length of nums list
Space Complexity : O(n) where n is the length of nums list
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        n = len(nums)
        arr = [0]*n
        arr[0] = nums[0]
        size = 1
        # We copy the first element on the first position of new array. The we perform 
        # Binary search and keep on finding the next greater element and also 
        # incrementing the size.
        for i in range(1, n):
            if nums[i] > arr[size - 1]:
                arr[size] = nums[i]
                size += 1
            else:
                index = self.binarySearch(arr, 0, size - 1, nums[i])
                arr[index] = nums[i]
        return size
    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = (high + low)//2
            if arr[mid] == target: return mid
            elif target < arr[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return low