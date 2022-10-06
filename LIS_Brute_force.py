# Time complexity : O(n*n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # find the length of the array
        n = len(nums)
        
        # assign all one's to the array
        dp = [1]*n
        #max_val = 1
        
        # traverse over all the combination of the matrix which is all possibilities
        for i in range(1,n):
            for j in range(i):
                if nums[j] < nums[i]:
                    # the index value will be the max of the longest sequence + 1 or just the element at the current index
                    dp[i] = max(dp[j]+1,dp[i])
                #max_val = max(max_val, dp[i])
        
        # return the max value out of the array
        return max(dp)
