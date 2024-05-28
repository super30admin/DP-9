# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1]*len(nums)
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j]+1)
        return max(dp)

#Approach 2: using Binary Search
# Time Complexity : O(nlogn)
# Space Complexity : O(n)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        arr = [0]*n
        le = 1
        arr[0] = nums[0]

        for i in range(1, n):
            if(nums[i]>arr[le-1]):
                arr[le] = nums[i]
                le+=1
            else:
                bsIdx = self.binarySearch(arr, 0, le-1, nums[i])
                arr[bsIdx] = nums[i]
        
        return le
    
    def binarySearch(self, arr, low, high, target):
        while(low<=high):
            mid = int(low +(high-low)/2)
            if arr[mid] == target:
                return mid
            elif (arr[mid] > target):
                high = mid-1
            else:
                low = mid+1
        
        return low