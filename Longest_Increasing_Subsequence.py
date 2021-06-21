class Solution:
    
    #DP
    def lengthOfLIS_DP(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        dp = [1] * n
        #print(nums)
        for i in range(1,n):
            #print(dp)
            for j in range(0,i):
                if nums[i] > nums[j]:
                    dp[i] = max (dp[i], dp[j] + 1)
        
        return max(dp)
                
    #Binary Search          
    #Todo
    
    
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        dp = [0] * n
        dp[0] = nums[0]
        idx = 1 
        for i in range(1,n):
            if dp[idx-1] < nums[i]:
                dp[idx] = nums[i]
                idx +=1
            else:
                replace_idx = self.binarysearch(dp,nums[i],0,idx -1)
                dp[replace_idx] = nums[i]
                
        
        return idx
    
    def binarysearch(self,dp,val,low,high):
        
        
        while low<=high:
            mid = low + (high -low)//2
            
            if dp[mid] == val:
                return mid
            elif dp[mid] < val:
                low = mid +1
            else:
                high = mid -1
        
        return low
        
                    
                
