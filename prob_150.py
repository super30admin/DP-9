#time  =  o(log n ** 2)
#leetcode 300
#leetcode - passed in leetcode
#logic : Create a dp array with max number of elements that can be formed follwoing the order given and use that to find the next elemnts max count and finall giveout the highest subsequence value
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # edge case
        if len(nums) == 0:
            return 0
        # variables
        dp = [1 for i in range(len(nums))]
        # return variables
        ret_val = 1
        max_sub_sequence = 0
        # logic
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    # if dp[j] > max_sub_sequence:
                    max_sub_sequence = max(dp[j], max_sub_sequence)
            dp[i] = dp[i] + max_sub_sequence  # since the intial vaule in dp array is 1
            ret_val = max(ret_val, dp[i])
            max_sub_sequence = 0
        return ret_val

