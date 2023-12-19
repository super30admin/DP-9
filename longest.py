# Time: O(n^2)
# Space: O(n) 
# Did it run on Leetcode: yes

class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # n=len(nums)
        # dp=[1]*(n)
        # maxel=1
        # for i in range(1,n):
        #     for j in range(i):
        #         if(nums[i]>nums[j]):
        #             dp[i]=max(dp[i],dp[j]+1)
        #             maxel=max(maxel, dp[i])
        # return maxel

        n=len(nums)
        dp=[1]*(n)
        maxel=1
        for i in range(1,n):
            for j in range(i):
                if(nums[i]>nums[j]):
                    # allsubs.append(list(nums[j]))
                    dp[i]=max(dp[i],dp[j]+1)
                    maxel=max(maxel, dp[i])
        # print(allsubs)
        return maxel