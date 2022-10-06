# Time complexity : O(n*logn)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        # if nums array is empty then return 0
        if not nums:
            return 0
        
        # find the length of the nums array and an empty array to keep track of the sequence
        n = len(nums)
        arr = []
        max_val = 1
        arr.append(nums[0])
        l = 1
        
        # iterate over the nums list
        for i in range(1,n):
            # if we find an increasing order of sequence then append the number to the array
            if arr[-1] < nums[i]:
                arr.append(nums[i])
            else:
              # it maybe that a new sequence could be longer
                # else find a position in the array that can place the current element in the new index using binary search
                idx = self.binarySearch(arr, 0, len(arr)-1, nums[i])
                
                # place the element there
                arr[idx] = nums[i]
        
        # return the lenght of the array
        return len(arr)
    
    # Binary search to search for the place to replace the element
    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                return mid
            if arr[mid] < target:
                low = mid + 1
            elif arr[mid] > target:
                high = mid - 1
        return low
