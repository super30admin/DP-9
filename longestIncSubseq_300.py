# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:

# Brute Force: exploring all subsequence-> how? C/DC at every point [10-18], C: 10[9-18], DC: [9-18], repeating subproblem. T.C.: O(2^n)
# [2,3,7,101] to get this at some point we must have calculated if [2,3,7] were valid. Hence, no need to re-calculate this and just check another element if its valid and increase the count for length if its valid. 
# Maintain an array which calculates the LIS at that element, initialised with 1.
# start i=1 and j=0, as the first index will always have 1 as the LIS. Is nums[i]<num[j]: move i forward. Also, check j from 0 to i for every i and if nums[j]<nums[i], update dp[i] = max(dp[i], dp[j]+1). Return the max value

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums == None or len(nums)==0:
            return 0

        dp = [1]*len(nums)
        for i in range(1,len(nums)):
            for j in range(0, i):
                if nums[i]>nums[j]:
                    dp[i] = max(dp[i], 1+dp[j])
        
        return max(dp)
                    
        
        