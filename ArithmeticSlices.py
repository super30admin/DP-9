# -*- coding: utf-8 -*-
"""
Created on Fri Mar 20 00:31:02 2020

@author: WELCOME
"""
"""
Arithmetic Slices
DP
Time - O(N)
Space - O(N)
"""

class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        sum=0
        arr=[0]*len(A)
        for i in range(2,len(A)):
            if A[i]-A[i-1]==A[i-1]-A[i-2]:
                arr[i]+=arr[i-1]+1
                sum+=arr[i]
        return sum