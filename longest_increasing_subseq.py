"""
// Time Complexity : O(Nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        
        10,101
        9,101
        2,5,7,101
        
        Idea (Flawed, didn't consider case like [-1000,10,9,2,5,3,7,101,18] 
        doesn't not consider all combinations of increasing subsequence)
        - For each element starting at i, iterate from i+1 till the end
            length = 0
            - If prev element < current element:
                prev_element  =current_element
                increment the length
            - keep a track of maximum length
        - Return the length
        """
#         if not nums:
#             return 0
#         max_length = 1
#         for i in range(len(nums)):
#             length = 1
#             prev_element = nums[i]
#             for j in range(i+1,len(nums)):
#                 if prev_element < nums[j]:
#                     prev_element = nums[j]
#                     length+=1
                
#             max_length = max(max_length,length)
#         return max_length
        
    
        """
        Correct (N2) algo  (DP version)
        - The main idea is element on its own will have at least length of 1 as increasing subsequence length -> dp array initialize to 1 for all places of length nums
        - For i = 1 to nums.length
            For j = 0 to i
                if nums[i] > nums[j] -> expand the increasing subsequence length
                    dp[i] = max(dp[i],dp[j]+1)
                    update max_len using dp[i]
        - return max_len
        """
        if not nums:
            return 0
        dp = [1] * len(nums)
        max_len = 1
        for i in range(1,len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i],dp[j]+1)
                    max_len = max(max_len,dp[i])
        return max_len
        """
        Nlogn optimal solution
        Initial configuration - result - [nums[0]]
        Main algo
        - For i = 1 to N
            if nums[1] > result:
                result.append(nums[1])
            else:
                - Use binary search to find the position for placing the position in right order in current result sequence and replace the existing element at obtained position
        - Return the length of the result
        """
        def bsearch(arr,low,high,s):
            while low <= high:
                mid = (low + high) // 2
                if arr[mid] == s:
                    return mid
                if s > arr[mid]:
                    low = mid + 1
                else:
                    high = mid - 1
            return low
        
        if not nums:
            return 0
        
        result = [0]
        result[0] = nums[0]
        
        result_len = 1
        for i in range(1,len(nums)):
            #expanding the result with increasing sequence
            if nums[i] > result[-1]:
                result.append(nums[i])
                result_len+=1
            else:
                #new_pos = bisect.bisect_left(result, nums[i], lo=0) #-> slower than plain bsearch
                #finding the right position for current element to be fitted inside the result sequence
                new_pos = bsearch(result,0,len(result),nums[i])
                
                #replacing the old element at new_pos with current element
                result[new_pos] = nums[i]
        return len(result)