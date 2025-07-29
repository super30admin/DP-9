# TimeComplexity:O(nlogn)
# SpaceComplexity:O(n)
# Approach:
# BF genrate all possible subsequence we can do this by 01 recursion tc would be exponentional 
# DP We can see in the tree that there are lot of repeated sub problems dp[i] -states that we our possible LIS is ending with nums[i]
# Optimal+ BS at every num we will consiber that number mighr be part of out LIS we start with nums[0] and if curr num is greater than last num 
#             of temp LIS we add otherwise we find just greater num than that and repalce that with this .




#-----------------------
#updating existing LIS using BS
#-----------------------

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        def bs(nums, i):
            l, h = 0, len(nums) - 1
            ans = len(nums)  # Default index if all elements < i

            while l <= h:
                mid = (l + h) // 2
                if nums[mid] >= i:
                    ans = mid  # potential answer, but look left for smaller ≥ i
                    h = mid - 1
                else:
                    l = mid + 1

            return ans



        ans=[nums[0]]
        for i in range(1,len(nums)):
            # print(ans,nums[i])
            if nums[i]>ans[-1]:ans.append(nums[i])
            else:
                idx=bs(ans,nums[i])
                # print(ans,nums[i],idx)
                ans[idx]=nums[i]
        return len(ans)

#--------------------------
# Using dp ,o(n^2)
#--------------------------


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp=[1 for _ in range(len(nums))]
        mx=float('-inf')
        for i in range(len(nums)):
            for j in range(i+1):
                if nums[j]<nums[i]:
                    dp[i]=max(dp[j]+1,dp[i])
            mx=max(mx,dp[i])
      
        return mx





