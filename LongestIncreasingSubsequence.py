# // Time Complexity : o(nlogn)
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# We try to build the longest sequence smartly by keeping only useful numbers.
# If the number is larger than the last, we extend the effective array; otherwise, we replace using binary search.
# The final length of this effective array gives us the LIS length.

from typing import List
# class Solution:
#     def lengthOfLIS(self, nums: List[int]) -> int:
#         maxres,n = float('-inf'),len(nums)
#         dp = [1]*n
#         for i in range(1,n):
#             for j in range(i):
#                 if nums[i] > nums[j]:
#                     dp[i] = max(dp[i], 1+dp[j])
#                     maxres = max(dp[i], maxres)
                
#         return maxres if maxres!=float('-inf') else 1

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        maxarr = [0]*n
        maxarr[0] = nums[0]
        length = 1
        def bsearch(maxarr,l,h,target):
            while l<=h:
                mid = l +(h-l)//2
                if target == maxarr[mid]:
                    return mid
                elif target> maxarr[mid]:
                    l = mid+1
                else:
                    h = mid-1
            return l
        for i in range(1,n):
            if nums[i] > maxarr[length-1]:
                maxarr[length] = nums[i]
                length+=1
            else:
                bsindex = bsearch(maxarr,0,length-1,nums[i])
                maxarr[bsindex] = nums[i]
        return length

# class Solution:
#     def lengthOfLIS(self, nums: List[int]) -> int:
#         n = len(nums)
#         memo = [[None]*(n+1) for _ in range(n)]
#         def helper(prev, curr):
#             # base
#             if curr >= len(nums): return 0
#             if memo[curr][prev+1] : return memo[curr][prev+1]

#             # logic
#             curr1 = helper(prev, curr+1)
#             curr2 = 0
#             if prev == -1 or nums[curr] > nums[prev]:
#                 curr2 = 1+ helper(curr, curr+1)
#             memo[curr][prev+1] = max(curr1,curr2)
#             return max(curr1,curr2)
#         return helper(-1,0)
        
                
