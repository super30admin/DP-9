# time complexity is O(nlogn)
# space compelxity is O(n)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # dp method
        # move i in for loop always, j comes back to 0 index for each i loop

        n = len(nums)
        dp = [1] * n
        res = 1

        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    res = max(res, dp[i])
        return res
        # better than dp-O(nlogn) using binary search

        n = len(nums)
        if n == 0:
            return 0

        arr = []

        for num in nums:
            if not arr or num > arr[-1]:

                arr.append(num)
            else:

                bs_index = self.binary_search(arr, 0, len(arr) - 1, num)
                arr[bs_index] = num

        return len(arr)

    def binary_search(self, arr, low, high, target):

        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low
