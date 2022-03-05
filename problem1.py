# TC:O(n log n)
# SC:O(n)

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        dp = [0] * len(nums)
        dp[0] = nums[0]
        _len = 1
        for i in range(1, len(nums)):
            if nums[i] > dp[_len - 1]:
                dp[_len] = nums[i]
                _len += 1
            else:
                idx = self.binarysearch(dp, nums[i], 0, _len - 1)
                dp[idx] = nums[i]

        return _len

    def binarysearch(self, dp, num, low, high):
        while low <= high:
            mid = int(low + (high - low) / 2)

            if dp[mid] == num:
                return mid
            elif dp[mid] > num:
                high = mid - 1
            else:
                low = mid + 1

        return low