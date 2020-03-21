# -*- coding: utf-8 -*-
"""
Created on Sat Mar 21 04:15:18 2020

@author: WELCOME
"""
"""
Russian Doll Envelopes
Recursive DP Solution
Time - O(N^2)
Space -O(N)
I'm finding Recursive DP more intuitive for all problems over iterative DP. Please let me know if I can continue with these solutions instead of iterative.
"""

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        envelopes.sort(key = lambda x:x[0])
        print(envelopes)
        dpMemo={}
        ans=0
        def recursion(index):
            nonlocal ans
            if tuple(envelopes[index]) in dpMemo:
                return dpMemo[tuple(envelopes[index])]
            if index>=len(envelopes)-1:
                return 0
            
            maxi=0
            for i in range(index+1,len(envelopes)):
                a=recursion(i)
                if envelopes[index][0]<envelopes[i][0] and envelopes[index][1]<envelopes[i][1]:
                    maxi=max(a+1,maxi)
            if maxi>ans:
                ans=maxi
            dpMemo[tuple(envelopes[index])]=maxi
            return maxi
            
            
        recursion(0)
        return ans+1