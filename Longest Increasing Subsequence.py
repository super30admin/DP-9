class Solution:
    #Solution 1
    def lengthOfLIS(self, nums: List[int]) -> int:
        #Approach: Modified Binary Search
        #Time Complexity: O(n log n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        eff_seq = []
        
        for num in nums:
            if not eff_seq or eff_seq[-1] < num:
                eff_seq.append(num)
                
            else:
                idx = self.binarySearch(eff_seq, num)
                eff_seq[idx] = num
                
        return len(eff_seq)
    
    def binarySearch(self, arr, target):
        low = 0
        high = len(arr) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        
        return low
    
    #Solution 2
    """
    def lengthOfLIS(self, nums: List[int]) -> int:
        #Approach: Dynamic Programming
        #Time Complexity: O(n^2)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        dp = [1 for _ in nums]
        result = 1
        
        for i in range(1, len(dp)):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
            result = max(result, dp[i])
                    
        return result
    """