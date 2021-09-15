#Space:O(n)
#Time:O(n^2)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp_array = [1]*len(nums)
        for i in range(1,len(nums)):
            for j in range(i):
                if nums[j]<nums[i]:
                    dp_array[i]=max(dp_array[i],dp_array[j]+1)
        return max(dp_array)