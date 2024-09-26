# -*- coding: utf-8 -*-
"""
Created on Fri Mar 20 00:31:02 2020

@author: WELCOME
"""
"""
Triangle
DP
Time - O(N)
Space - O(N)
where N is number of elements
"""

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        for i in range(1,len(triangle)):
            for j in range(len(triangle[i])):
                if j==0:
                    triangle[i][j]=triangle[i][j]+ triangle[i-1][j]
                elif j==len(triangle[i])-1:
                    triangle[i][j]=triangle[i][j] + triangle[i-1][j-1]
                else:
                    triangle[i][j]=triangle[i][j]+min(triangle[i-1][j-1],triangle[i-1][j])
                    
                
                
        return min(triangle[-1])
