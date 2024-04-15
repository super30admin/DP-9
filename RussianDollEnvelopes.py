'''
TC: O(n*logn) - iterate through the envelopes and create nums for 
            heights alone by sorting with (increasing widths and decreasing heights)
            and used binary search 
            to find the just largest number than the searching number
SC: O(n) - to create an increasing sequence
'''
from typing import List

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        res = []
        nums = []
        envelopes.sort(key=lambda x:(x[0],-x[1]))
        for i,j in envelopes:
            nums.append(j)

        def binarySearch(res, num):
            l,h = 0,len(res)-1
            while l<h:
                mid = (l+h)//2
                if res[mid]>=num:
                    h = mid
                else:
                    l = mid+1
            return l

        for num in nums:
            if not res:
                res.append(num)
            else:
                i = binarySearch(res,num)
                if i == len(res)-1 and res[-1] < num:
                    res.append(num)
                else:
                    res[i] = num
        return len(res)