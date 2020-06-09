"""
// Time Complexity : O(Nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
- Transform the problem into longest increasing subsequence for the heigths 
by sorting the original envelopes based on the comparator logic
Sorting the envelopes array based on the comparator, where if w1[0] == w2[0],
sort based on descending height, else sort based on ascending height
- Return the length of result array in the end( Bsearch logic LIS)
Disclaimer - Python 3, normal LIS doesn't work here(TLE)
"""
from bisect import bisect_left
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        #temp = sorted(envelopes,key = lambda x:x[0]) #this keeps height in ascending only -> incorrect for problem
        """
        Sorting the envelopes array based on the comparator, where if w1[0] == w2[0], sort based on descending height, else sort based on ascending height
        """
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        
        def lis(nums):
            print(nums)
            result = []
            for i in range(len(nums)):
                #bsearch get the correct order to place the element in the result array
                new_pos = bisect_left(result,nums[i])
                #replacing the old element at new_pos with current element
                if new_pos == len(result): #out of bounds, expand the result
                    result.append(nums[i])
                else:
                    #replace the element at new pos with current element
                    result[new_pos] = nums[i]
            return len(result)
        return lis([i[1] for i in envelopes])