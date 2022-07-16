'''
Using DP
Time: O(n^2)
Space: O(n)
'''

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        n = len(nums)
        ma = 1
        dp = [1 for _ in range(len(nums))]
        
        for i in range(1,len(nums)):
            
            for j in range(0,i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i],dp[j] + 1)
                    ma = max(ma, dp[i])
                    
        return ma
                

'''
(no need to come up with the interview)
Algo for finding the longest length (not the exact sequence)
Time: O(nlogn)
Space: O(n)
'''

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        n = len(nums)
        
        arr = [0 for _ in range(len(nums))]
        
        len_p = 1
        arr[0] = nums[0]
        
        for i in range(1,len(nums)):
            if arr[len_p - 1] < nums[i]:
                arr[len_p] = nums[i]
                len_p += 1
            else:
                bsind = self.binarysearch(arr, nums[i],0,len_p-1)
                arr[bsind] = nums[i]
        
        return len_p
                
        
    def binarysearch(self, arr, target,l,r):
        while l <= r:
            m = l + (r-l)//2
            if arr[m] == target:
                return m
            elif arr[m] > target:
                r = m - 1
            else:
                l = m + 1
        return l
                
                
        