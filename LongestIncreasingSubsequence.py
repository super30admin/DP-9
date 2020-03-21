# -*- coding: utf-8 -*-
"""
Created on Fri Mar 20 00:25:55 2020

@author: WELCOME
"""
"""
Longest Increasing Subsequence
Recursive DP Solution
Time - O(N^2)
Space - O(N)
"""
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        memo={}
        if not nums:
            return 0
        sumVar=0
        def recursion(index):
            nonlocal sumVar
            if index in memo:
                return memo[index]
            if index>=len(nums):
                return 0
            maxi=0
            for i in range(index+1,len(nums)):
                a=recursion(i)
                if nums[i]>nums[index]:
                    maxi=max(maxi,a+1)
            if maxi>sumVar:
                sumVar=maxi
            memo[index]=maxi
            return maxi
        recursion(0)
        return sumVar+1