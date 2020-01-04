'''
leetcode- 300. Longest Increasing Subsequence
time complexity - O(N2)
space complexity - o(N)

Approach - DP- 1) first we fill the dp elements by 1
               2) At every iteration we start the j from starting onwards and we compare it with ith element
               3) if it is increasing them maxsub becomes max(maxsub,dp[j])
               4) dp[i] =dp[i] + maxsub
               5) we maintain global retval 
'''
class Solution:
    retval=1
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        dp =[1 for _ in range(len(nums))]
        for i in range(1,len(nums)):
            maxsub=0
            for j in range(i):
                if nums[i]>nums[j]:
                    maxsub=max(maxsub,dp[j])
            dp[i]=dp[i]+maxsub
            self.retval=max(self.retval,dp[i])
                    
            
        return self.retval
            