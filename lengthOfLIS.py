class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        '''
        T = O(NlogN) , N -> length of the nums
        S = O(N)
        
        '''
        if not nums: return 0 
        n = len(nums)
        dp = [0]*n
        dp[0] = nums[0]
        len_ = 1 
        for i in range(1, n):
            if nums[i] > dp[len_ -1]:
                dp[len_] = nums[i]
                len_ += 1 
            else:
                idx = self.binary_search(dp, nums[i] , 0 , len_ - 1 )
                dp[idx] = nums[i] 
        return len_
	
    def binary_search(self, nums,target,low,high):
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return low

    def subOptimallengthOfLIS(self, nums: List[int]) -> int:
        '''
        T = O(N^2) , N -> size of the input array 
        S = O(N)
        '''
        dp = [1]*len(nums)
        max_ = 1
        for i in range( 1 , len(nums) ):
            for  j in range(0 , i):
                if nums[j] < nums[i]:
                    dp[i] = max( dp[i] , dp[j] + 1 )
            max_ = max(max_ , dp[i])
        return max_
            
            
