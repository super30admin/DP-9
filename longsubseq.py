# brute force solution
# check for every possible combination  using recursion.
# Time complexity - O(2^n)
# Space complexity - O(n)
# Did this solution run on leetcode? - No (TLE)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        if n==0: return 0
        self.longsubseq = 1
        
        # try all possible pairs
        def rec(nums, idx, seqlen, prev):
            if idx == n:
                self.longsubseq = max(self.longsubseq, seqlen)
            while idx < n:
                if nums[idx] > prev:
                    rec(nums, idx+1, seqlen+1, nums[idx])
                else:
                    rec(nums, idx+1, seqlen, prev)
                idx += 1
                
        
        rec(nums, 0, 0, float('-inf'))
        return self.longsubseq
    
    
# Dynamic programming
# since this problem has repeated subsequences for ex - to find longest subseq in [10,12,15]
# if we have the solution for [10,12] we can solve for this problem by simply comparing [12,15]
# the longest subsequence would be of length 3.
# keep two pointers, pointer i which would traverse the whole nums array.
# another pointer j, which will begin from 0 till i-1
# check if the current value is greater than the value at j, dp[i] = dp[j]+1.
# Time complexity - O(n^2)
# Space complexity - O(n)
# Did this solution run on leetcode? - YEs
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        if n==0: return 0
        dp = [1] * n
        # dp = [(1, [num]) for num in nums]
        maxsubseq_len = 1
        
        for i in range(n):
            for j in range(i):
                if nums[i] > nums[j]:  # compare the current with the previous elements
                    dp[i] = max(dp[i], dp[j]+1)
                    maxsubseq_len = max(maxsubseq_len, dp[i])
                    
                    # if dp[i][0] < dp[j][0]+1:
                    #     dp[i] = (dp[j][0]+1, dp[j][1]+[nums[i]]) 
                        
                    # maxsubseq_len = max(maxsubseq_len, dp[i][0])
        
        return maxsubseq_len


# By maintaining a sub array.
# Traverse the array.
# for every incoming element, check if the last value in the found subarray sequence is less than the incoming value, append it to the subarray.
# increment the maxsubarray sequence by 1.
# if the element is not greater than the last element in the subsequence, find the next greatest closest value to it in the subarray and replace it with the current value.
# time complexity - O(n logn)
# space complexity - O(n)
# Did this solution run on leetcode? - yes
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        if n==0: return 0
        maxsubarray = [nums[0]]
        maxsubseq_len = 1
        
        # O(n) traverse over the array
        for i in range(n):
            num = nums[i]
            if num > maxsubarray[-1]:
                maxsubarray.append(num)
                maxsubseq_len += 1
            else:
                idx = self.__bsearch(maxsubarray, num) # find the next greater element O(log n)
                maxsubarray[idx] = num
        
        return maxsubseq_len
                
    def __bsearch(self, maxsubarray, target):
        """
            Search for next greater number in the subarray.
        """
        low, high = 0, len(maxsubarray)
            
        while low<=high:
            mid = low + (high-low)//2
            if maxsubarray[mid] == target:
                return mid
            elif maxsubarray[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low
    