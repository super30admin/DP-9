# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        lis = [1] * len(nums)
        max_l = 1
        for i in range(1, len(nums)):
            possible_ext = [1 + lis[j] for j in range(0, i) if nums[j] < nums[i]]
            if len(possible_ext) > 0:
                lis[i] = max(possible_ext)
                max_l = max(max_l, lis[i])
        return max_l