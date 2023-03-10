#time O(N*N)
#space O(N)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp=[1]*len(nums)
        for i in range(1,len(nums)):
            j=0
            while j<i:
                if nums[j]<nums[i]:
                    dp[i]=max(dp[i],dp[j]+1)
                j+=1
        return max(dp)

        