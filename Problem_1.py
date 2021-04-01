# Optimized one with Binary search
#Time Complexity: O(nlogn)
# Space Complexity:  O(n)

# Understood the approach very well!
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        
        effBSArray = []
        len_point = 1 # len_point put on effBSArray
        effBSArray.append(nums[0])
        
        for i in range(1, len(nums)):
            if nums[i] > effBSArray[-1]:
                effBSArray.append(nums[i])
                len_point += 1
            else:
                bsIdx = self.binarySearch(effBSArray, 0, len(effBSArray)- 1, nums[i])
                effBSArray[bsIdx] = nums[i]
                
        return len_point
    
    def binarySearch(self, effBSArray, low, high, target): # normal and closed Binary search
        while low <= high:
            mid = low + (high - low) // 2
            if effBSArray[mid] == target:
                return mid
            if effBSArray[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low # low is always ending at the right position 
		
# DP Solutions

#Time Complexity: O(n^2)
# Space Complexity:  O(n)

class Solution(object):
    def lengthOfLIS(self, nums):
        if not nums:
            return 0
        maxi = 1
        
        dp = [1] * len(nums)
        
        for i in range(1, len(nums)):
            for j in range(0, i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    maxi = max(maxi, dp[i])
                    
        return maxi
