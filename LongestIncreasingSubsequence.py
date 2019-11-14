#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov 14 14:14:51 2019

@author: tanvirkaur
"""

class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        time complexity = O(N^2)
        space complexity = O(N)
        Brute Force solution: we will find all the possible subsets of the given array(exponential) and then find the length of all increasing subsequences in all the subsets(O(N^2)) . total complexity = O(2^n + n^2) = O(2**n)
        """
        dp = [1 for x in range(len(nums))]
        for i in range(1,len(nums)):
            for j in range(0,i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i],dp[j]+1)
        return max(dp)
                 