'''
Time Complexity : O(nlogn) in worst case run Binary search for all elements in the nums list
Space Complexity : O(n) store elements in arr
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Approach: Make a new temp array to maintain elements in the sorted/ increasing order. 
- Keep checking if current value is greater then last element of temp array
    - yes, append the value to temp array
    -if value is smaller, we need to find the position were this element can be added using binary search.
- return length of the temp array as that would be longest increasing subsequence.

'''

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        length = len(nums)
        arr = []
        arr.append(nums[0])
        for i in range(1, length):
            if nums[i] > arr[-1]:
                arr.append(nums[i])
            else:
                position = self.binarySearch(
                    arr, 0, len(arr)-1, nums[i])
                arr[position] = nums[i]
        return len(arr)

    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = (low+high)//2
            if arr[mid] == target:
                return mid
            if arr[mid] > target:
                high = mid-1
            else:
                low = mid+1
        return low
