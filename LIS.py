'''
Solution:
1.  The main idea is to store the Longest Increasing Subsequence at each index (till that index).
2.  In order to store the LIS for each index, consider LIS for all previous indices where
    current index's value is greater than previous index's value and keep updating if LIS greater
    is found.
3.  Also, keep track of max LIS seen so far for all indices seen so far, return the final max LIS. 

Time Complexity:    O(n^2)     |   Space Complexity:   O(n)

Dynamic Programming + Binary Search applied on Russian Dolls problem !!!
--- Passed all testcases successfully on leetcode.
'''


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        #   edge case check
        if (nums == None or len(nums) == 0):
            return 0
        
        #   initializations
        output = [1 for i in range(len(nums))]
        maxLen = 1
        
        #   for each index
        for i in range(1, len(nums)):

            #   iterate over all previous indices where current value > previous value
            for j in range(i - 1, -1, -1):
                if (nums[i] > nums[j]):
                    output[i] = max(output[i], 1 + output[j])   #   update the current LIS accordingly
            
            #   also update max LIS seen so far
            maxLen = max(maxLen, output[i]) 
        
        #   return max LIS seen till last index           
        return maxLen