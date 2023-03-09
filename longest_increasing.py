# Time Complexity :
# O(N ^2)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We store a DP array that contains the longest increasing subsequence found until that location. 
#We process each element in the array and check if the new element can be added to any of the previous subsequences until then  - if it is (if the current elem is bigger than end of prev subsequence), then current element can be added to the subsequence and we see if this subsequence length is higher than what we already have and update based on that
#In the end, we return the max of DP array - whereever we can find the max longest subsequence

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1] * n
        
        for i in range(0,n):
            for j in range(0,i):
                if nums[i] > nums[j] :
                    dp[i] = max(dp[j]+1, dp[i])

        return max(dp)
