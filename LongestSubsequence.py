#Time Complexity : O(N*M) where N is Number of rows and M is number of Columns
#Space Complexity : O(N) Number of elements stored in dp
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums) ==0:
            return 0
        max1 = 1
        dp = [1 for x in range(len(nums))]
        for i in range(1,len(nums)):
            for j in range(0,i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j]+1)
                    max1 = max(max1,dp[i])
        return max1
=========================================================================================================
#Time Complexity : O(N*LOGN) where N is Number of elements
#Space Complexity : O(1)
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def binarysearch (dp, target, low, high):
            while(low <= high):
                mid = low + (high - low)//2
                if target == dp[mid]:
                    return mid
                elif dp[mid] > target:
                    high = mid -1
                else:
                    low = mid +1
            return low
        
        
        
        if len(nums) ==0:
            return 0
        len1 = 0
        n = len(nums)
        dp = [1 for x in range(len(nums))]
        dp[len1] = nums[0];
        len1+=1
        print(dp)
        
        for i in range(1,len(nums)):
            if dp[len1 -1]<nums[i]:
                dp[len1]= nums[i]
                len1+=1
            else:
                idx = binarysearch(dp,nums[i],0,len1)
                dp[idx] = nums[i]
        return len1 
        
