# Brute Force 
# Choose or dont choose, evaluate all paths, results in repeated sub problems)
# Time - O( 2 ^ N) since at every node we make 2 choices


# Optimized Solution 1 - DP ( Optimize repeated sub problems)
# Time - O(N ^ 2) Nested loops
# Space - O(N)

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        if not nums or len(nums) == 0:
            return 0
        
        dp = [1] * len(nums) # initialize with 1's as every number is its own LIS
        max_len = 1
        
        for i in range(1, len(nums)):
            for j in range(0, i): # we keep iterating up until i to see if any other comb can result in max
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    max_len = max(max_len, dp[i])
                    
        return max_len


# Optimised Solution 2 - Binary search
# Maintain an effective LIS array - initially with first val of array
# Iterate over array of nums and if num > last element in LIS array, append to LIS array, increment seq length
# If num < LIS array's last element - get the closest/next highest number (comapred to current) in LIS array using BInary search
# Using this index, replace val at Binary Idx at LIS array with current num
    # Intuition - To check if we can maximize the seq length
# Time - O(N log N)
# Space - O(N)

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        if not nums or len(nums) == 0:
            return 0
        
        res = []
        seq_len = 1
        
        res.append(nums[0])
        
        for i in range(len(nums)):
            
            if nums[i] > res[-1]:
                res.append(nums[i])
                seq_len += 1
                
            else:
                binary_idx = self.binarySearch(res, nums[i], 0, len(res))
                res[binary_idx] = nums[i]
                
        return seq_len
    
    
    def binarySearch(self, nums, target, low, high):
        
        while low <= high:
            
            midd = low + (high - low) // 2
            
            if nums[midd] == target:
                return midd
            
            elif nums[midd] > target:
                high = midd - 1
                
            else:
                low = midd + 1
                
        return low
            
        
        