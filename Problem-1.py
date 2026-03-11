# Time Complexity : O(N log N)  # Binary search for each element to maintain LIS array
# Space Complexity : O(N)      # Store LIS sequence
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Maintain an array where index i stores the smallest ending element of an increasing subsequence of length i+1.
# For each number, find its position using binary search and replace it.
# The size of this array at the end gives the length of the LIS.

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        import bisect
        
        lis = []
        
        for num in nums:
            pos = bisect.bisect_left(lis, num)
            
            if pos == len(lis):
                lis.append(num)
            else:
                lis[pos] = num
        
        return len(lis)