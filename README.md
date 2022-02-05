# DP-9

## Problem1: Longest Increasing Subsequence (https://leetcode.com/problems/longest-increasing-subsequence/)
#Time COmplexity = O(nlogn)
#Space COmplexity = O(n)

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        a=[0 for _ in range(len(nums))]
        a[0]=nums[0]
        curr=1
        def bs(al,b):
            low=0
            high=curr-1
            while low<=high:
                mid=(low+high)//2
                if a[mid]==al:
                    return mid
                elif a[mid]<al:
                    low=mid+1
                else:
                    high=mid-1
            return low      
        for i in range(1,len(nums)):
            if nums[i]>a[curr-1]:
                a[curr]=nums[i]
                curr+=1
            else:
                index=bs(nums[i],curr)
                a[index]=nums[i]
        return curr
                
        
        
## Problem2: Russian Doll Envelopes (https://leetcode.com/problems/russian-doll-envelopes/)

#Time COmplexity = O(nlogn)
#Space COmplexity = O(n)

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x:x[0])
        dp=[1 for _ in range(len(envelopes))]
        maxi=1
        for i in range(1,len(envelopes)):
            for j in range(0,i):
                if envelopes[i][1]>envelopes[j][1] and envelopes[i][0]>envelopes[j][0]:
                    dp[i]=max(dp[i],dp[j]+1)
            maxi=max(maxi,dp[i])
        return maxi
        