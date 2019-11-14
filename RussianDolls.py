#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov 14 14:16:47 2019

@author: tanvirkaur
"""

#Leetcode acceptance = No, Time limit exceeded error
class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        if not envelopes:
            return 0
        envelopes.sort(cmp = lambda x,y: x[0] -y[0] if x[0]!=y[0] else y[1]-x[1])
        dp = [1]*len(envelopes)
        for i in range(1,len(envelopes)):
            for j in range(0,i):
                if envelopes[i][1] > envelopes[j][1]:
                    dp[i] = max(dp[j]+1,dp[i])
        return max(dp)
            