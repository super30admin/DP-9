TC: O(2^n)
SC: O(h)
#Time-Limit exceeded
class Solution:
    global result
    def lengthOfLIS(self, nums: List[int]) -> int:
        self.result=0
        self.helperFunction(0, nums, [])
        return self.result
    
    def helperFunction(self, pos, nums, arr):
        if pos >= len(nums):
            self.result = max(self.result, len(arr))
            return
        # choose
        if not arr or nums[pos] > arr[-1]:
            self.helperFunction(pos+1, nums, arr+[nums[pos]])
        # Not choose
        self.helperFunction(pos+1, nums, arr)


-------------------------------------------------
TC: O(n^2)
SC: O(n)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp=[1]*len(nums)
        result=1
        for i in range(1,len(nums)):
            for j in range(0, i):
                if nums[i]>nums[j]:
                    dp[i]=max(dp[j]+1,dp[i])
                    result=max(result,dp[i])
        return result