# -*- coding: utf-8 -*-
"""
Created on Fri Mar 20 00:29:52 2020

@author: WELCOME
"""
"""
LIS
Iterative DP Solution
Time - O(N^2)
Space - O(N)
"""

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        arr=[1]*len(nums)
        for i in range(len(nums)-2,-1,-1):
            temp=0
            for j in range(i+1,len(nums)):
                if nums[i]<nums[j]:
                    temp=max(temp,arr[j])
                arr[i]=temp+1
        return max(arr)