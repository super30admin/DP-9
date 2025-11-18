# Time Complexity : O(NlogN) as we are iterating through the list once and performing binary search for each element
# Space Complexity : O(N) as we are using extra space to store the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Your code here along with comments explaining your approach:
# I am using a dynamic programming approach with binary search to find the length of the longest increasing subsequence.
# I maintain a list 'res' which will store the smallest tail of all increasing subsequences
# with different lengths found so far. For each number in the input list, I use binary search to find its position in 'res'.
# If the number is larger than all elements in 'res', it is appended to 'res'. Otherwise, it replaces the first element in 'res'
# which is greater than or equal to it. The length of 'res' at the end will be the length of the longest increasing subsequence.

from typing import List
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        res = []
        for i in nums:
            low = 0
            high = len(res)
            while low < high:
                mid = low + (high - low) // 2
                if res[mid] >= i:
                    high = mid
                else:
                    low = mid + 1
            if len(res) == low:
                res.append(i)
            else:
                res[low] = i
        return len(res) 

        