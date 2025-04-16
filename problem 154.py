# https://leetcode.com/problems/longest-increasing-subsequence/

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        self.arr = [0] * (n)
        self.arr[0] = nums[0]
        idx = 1

        for i in range(1,n):
            if nums[i] > self.arr[idx-1]:
                self.arr[idx] = nums[i]
                idx += 1
            else:
                bsidx = self.binarysearch(self.arr,0,idx,nums[i])
                self.arr[bsidx] = nums[i]

        return idx
    
    def binarysearch(self,arr, low, high, target):

        while low <= high:
            mid = low + (high - low) // 2
            if self.arr[mid] == target:
                return mid
            elif self.arr[mid] > target:
                high = mid -1
            else:
                low = mid + 1
        return low

# TC: O(n logn) # BS for n elements in worst case
# SC: O(n)

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1] * (n)
        max_ans = 1
        for i in range(1,n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i],dp[j] + 1)
                    max_ans = max(max_ans,dp[i])

        return max_ans


# TC: O(n^2)
# SC: O(n)