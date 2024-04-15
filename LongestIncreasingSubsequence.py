'''
TC: O(n*logn) - iterate through the nums and used binary search 
            to find the just largest number than the searching number
SC: O(n) - to create an increasing sequence
'''
from typing import List

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        res = []

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
s = Solution()
print(s.lengthOfLIS([10,9,2,5,3,7,101,18]))
print(s.lengthOfLIS([0,1,0,3,2,3]))
print(s.lengthOfLIS([7,7,7,7,7,7,7]))