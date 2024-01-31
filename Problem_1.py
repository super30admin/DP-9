"""
Problem : 1

Time Complexity : 
Approach 1 - O(n^2)
Approach 2 - O(nlogn)

Space Complexity : 
Approach 1 - O(n)
Approach 2 - O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Longest Increasing Subsequence

# Approach - 1
# DP Array

class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        dp=[1 for _ in range(n)]

        for i in range(n):
            for j in range(i):
                if nums[i]>nums[j]:
                    dp[i]=max(dp[i],dp[j]+1)
        return max(dp)

# Approach - 2
# Binary Search
    
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        arr=[0 for _ in range(n)]
        arr[0]=nums[0]
        le=1
        for i in range(1,n):
            if nums[i]>arr[le-1]:
                arr[le]=nums[i]
                le+=1
            else:
                bsIdx=self.binarySearch(arr,0,le-1,nums[i])
                arr[bsIdx]=nums[i]
        return le

    
    def binarySearch(self,arr,start,end,num):
        while start<=end:
            mid=start+(end-start)/2
            if arr[mid]==num:
                return mid
            elif arr[mid]>num:
                end=mid-1
            else:
                start=mid+1
        return start