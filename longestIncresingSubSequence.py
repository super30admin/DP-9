# Time Complexity : O(nlgn)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        #can do reg dp or do dp w/ binarySearch      
        if not nums:
            return 0
        
        dp = [ 0 for i in range(len(nums))]
        length = 0
        dp[length] = nums[0]
        length += 1
        
        for i in range(1, len(nums)):
            if dp[length-1] < nums[i]:
                dp[length] = nums[i]
                length += 1
            else:
                index = self.bSearch(dp, nums[i], 0, length-1)
                dp[index] = nums[i]
                
        return length 
    
    def bSearch(self, dp, target, left, right):
        while left <= right:
            mid = left + (right-left)//2
            if target == dp[mid]:
                return mid
            elif dp[mid] > target:
                right = mid-1
            else:
                left = mid + 1
        return left