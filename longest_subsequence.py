# // Time Complexity :O(n^2)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

#O(N2),O(n)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp=[1 for i in range(len(nums))]
        print(dp)
        maxx=1
        for i in range(1,len(dp)):
            for j in range(0,i):
                if nums[i]>nums[j]:
                    dp[i]=max(dp[i],dp[j]+1)
                    maxx=max(maxx,dp[i])
        print(dp)            
        return maxx