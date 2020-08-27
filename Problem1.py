class Solution(object):
    def bin_search(self, arr, low, high, target): #function to find the closest greater value
        
        while low <= high:
            mid = low + (high - low)/2
            
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid -1
            else:
                low = mid + 1
                
        return low
        
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        """
        OPTIMIZED 
        time - o(nlogn)
        space - o(n)
        """
        
        if not nums:
            return 0
        
        seq = [0] * len(nums) 
        
        length = 1
        
        seq[0] = nums[0]
        
        
        for i in range(1, len(nums)):
            if seq[length - 1] < nums[i]: #if current element is greater than the one at the end of seq array, add it to the sequence
                seq[length] = nums[i]
                length += 1
            
            else:
                idx = self.bin_search(seq, 0, length - 1, nums[i]) #else find the closest greater number to the current value in seq array and replace it with nums[i]
                
                seq[idx] = nums[i]
                
        return length 
            
        
        """
        DP Array(non - optimal)

        time - 0(n^2)
        space - o(n)
        
        if not nums:
            return 0
        dp = [1] * len(nums) #creating a dp array, filled with 1s, as each element is an inc subsequence in itself
        
        for i in range(1, len(nums)): #checking for each element, teh longest inc subsequence it can form with elements to the left
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1) #length of longest subsequence at ith element
                    
        return max(dp)
        """