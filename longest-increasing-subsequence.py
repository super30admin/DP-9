# DP solution
# Time O(n^2)
# Space O(n)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1] * n
        #maxn = 1
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]: 
                    dp[i] = max(dp[i], dp[j] + 1)
                    #maxn = max(maxn, dp[i])
        return max(dp)

# BEST : Using BS
# Time O(n log n)
# Space O(n)   
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        effectiveIncreasingOrder = [nums[0]]
        for i in range(1, n):
            if nums[i] > effectiveIncreasingOrder[-1]:
                effectiveIncreasingOrder.append(nums[i])
            else:
                #find num just above nums[i] using Binary Search
                idx = self.findIndex(effectiveIncreasingOrder, nums[i])
                effectiveIncreasingOrder[idx] = nums[i]
        return len(effectiveIncreasingOrder)
    
    def findIndex(self, arr, target):
        low = 0
        high = len(arr) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return low
