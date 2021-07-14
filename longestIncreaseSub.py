# from bisect import bisect_left
# class Solution:
#     def lengthOfLIS(self, nums: List[int]) -> int:
#         pile_tops = [nums[0]]

#         for i in range(1, len(nums)):
#             # binary search to find insertion point
#             pos = bisect_left(pile_tops, nums[i])

#             # create new pile
#             if pos == len(pile_tops):
#                 pile_tops.append(nums[i])
#                 continue

#             # replace top of pile
#             pile_tops[pos] = nums[i]

#         return len(pile_tops)


class Solution:

    # DP
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        dp = [1] * n
        # print(nums)
        for i in range(1, n):
            # print(dp)
            for j in range(0, i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)

        return max(dp)