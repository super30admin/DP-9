# Problem 1: Longest Increasing Subsequence
from typing import List
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        arr = [0 for _ in range(n)]
        arr[0] = nums[0]
        Len = 1

        def BS(arr,low,high,target):
            while low <= high:
                mid = low + (high - low)//2
                if arr[mid] == target: return mid
                elif target < arr[mid]: high = mid - 1 
                else: low = mid + 1

            return low

        for i in range(1,n):
            if nums[i] > arr[Len-1]:
                arr[Len] = nums[i]
                Len += 1
            else:
                bsIndex = BS(arr,0,Len-1,nums[i])
                arr[bsIndex] = nums[i]
        
        return Len
        