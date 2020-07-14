# Time Complexity - O(N^N)
# Space Complexity - O(N)

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if(nums==None or len(nums)==0):
            return 0
        n = len(nums)
        dp = [1]*n
        for i in range(1,len(nums)):
            for j in range(0,i):
                if(nums[i]>nums[j]):
                    dp[i]= max(dp[i],dp[j]+1)
        maximum = 0
        for i in range(len(dp)):
            maximum = max(maximum , dp[i])
        return maximum
