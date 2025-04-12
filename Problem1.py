#time complexity o(n)
#space complexity o(n)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0] * n
        count = 0
        for i in range(n-3,-1,-1):
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
                dp[i] = dp[i+1] + 1
            else:
                dp[i] = 0
            count += dp[i]
        
        return count