class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums is None or len(nums) < 2:
            return 1
        n = len(nums)
        arr = [nums[0]]
        # arr[0] = nums[0]
        l = 1

        for i in range(1, n):
            # print(l, arr)
            if nums[i] > arr[l - 1]:
                arr.append(nums[i])
                l += 1
            else:
                bsIndex = self.binarySearch(arr, nums[i], 0, l - 1)
                if bsIndex != -1:
                    arr[bsIndex] = nums[i]

        return l

    def binarySearch(self, arr, target, low, high):
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low

# Binary Search
# Time Complexity: O(nlogn)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
