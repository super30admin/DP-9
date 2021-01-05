'''
Time Complexity : O(nlogn) for optimal solution and O(n^2) for DP solution
Space Complexity : O(n)
'''


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        bsArray = []
        bsArray.append(nums[0])
        
        for i in range(1,len(nums)):
            if nums[i] > bsArray[-1]:
                bsArray.append(nums[i])
            else:
                pos = self.binarySearch(bsArray, 0, len(bsArray)-1,nums[i])
                bsArray[pos] = nums[i]
        return len(bsArray)
        
    def binarySearch(self, bsArray, low, high, target):
        while(low<=high):
            mid = low + (high - low)//2
            
            if bsArray[mid] == target:
                return mid
            elif bsArray[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low
    
    
'''
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        dp = [1 for _ in range(len(nums)) ]
        m = 1
        for i in range(1,len(nums)):
            for j in range(0,i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j]+1)
                    m = max(m,dp[i])
                    
        return m  
'''   