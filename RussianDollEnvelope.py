# // Time Complexity : o(nlogn)
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# First we sort the envelopes by width, and for equal widths, by decreasing height.
# Then we apply LIS logic on the heights using a binary search optimized array.
# We place or replace the envelope height in the correct position to track the max length.

from typing import List
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key = lambda a: (a[0], -a[1]))
        maxarr = [0]*len(envelopes)
        length = 1
        maxarr[0],n = envelopes[0][1],len(envelopes)
        def binarysearch(l,h,target, maxarr):
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
            if envelopes[i][1] > maxarr[length-1]:
                maxarr[length] = envelopes[i][1]
                length+=1
            else:
                bsindex = binarysearch(0,length-1,envelopes[i][1],maxarr)
                maxarr[bsindex] = envelopes[i][1]
                
        return length

# class Solution:
#     def maxEnvelopes(self, envelopes):
#         envelopes.sort(key=lambda x: (x[0], -x[1]))
#         n = len(envelopes)
#         memo = [[None] * (n + 1) for _ in range(n)]

#         def helper(idx, prev):
#             if idx == n:
#                 return 0
#             if memo[idx][prev + 1] is not None:
#                 return memo[idx][prev + 1]

#             case0 = helper(idx + 1, prev)

#             case1 = 0
#             if prev == -1 or (envelopes[idx][0] > envelopes[prev][0] and envelopes[idx][1] > envelopes[prev][1]):
#                 case1 = 1 + helper(idx + 1, idx)

#             memo[idx][prev + 1] = max(case0, case1)
#             return memo[idx][prev + 1]

#         return helper(0, -1)

# class Solution:
#     def maxEnvelopes(self, envelopes):
#         n = len(envelopes)
#         envelopes.sort(key=lambda x: (x[0], -x[1]))
#         dp = [1] * n
#         result = 1

#         for i in range(1, n):
#             for j in range(i):
#                 if envelopes[j][1] < envelopes[i][1]:
#                     dp[i] = max(dp[i], dp[j] + 1)
#                     result = max(result, dp[i])

#         return result


        