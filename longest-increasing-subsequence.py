class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        n = len(nums)
        dp = [0]*n
        dp[0] = nums[0]
        curr_len = 1
        for i in range(1, n):
            if nums[i] > dp[curr_len-1]:
                dp[curr_len] = nums[i]
                curr_len += 1
            else:
                idx = self.binarySearch(nums[i], dp, 0, curr_len-1)
                dp[idx] = nums[i]
        return curr_len

    def binarySearch(self, val, dp, low, high):
        while low <= high:
            mid = (low+high)//2
            if dp[mid] == val:
                return mid
            elif(val > dp[mid]):
                low = mid+1
            else:
                high = mid-1
        return low
