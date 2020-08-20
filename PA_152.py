#Time Complexity - O(n^2)
#Space Complexity - O(n)
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        ans = 1
        tmp = [1] * len(nums)
        for i in range(1,len(nums)):
            for k in range(i):
                if nums[k] < nums[i]:
                    tmp[i] = max(tmp[i],tmp[k]+1)
                    ans = max(ans,tmp[i])
        return ans