"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
envelopes = [[5,4],[6,4],[6,7],[2,3]]

first sort the envolops based on 0th index and if the 0th index is same then based on 1st index
By iterating on the list, if the current element greater than the top at array
then append it to the array
else insert into the index of the element

"""

class Solution:
    def maxEnvelopes(self, nums: List[List[int]]) -> int:
        
        nums.sort(key=lambda x: (x[0], -x[1]))
        arr = []
        arr.append(nums[0][1])
        
        for i in range(1, len(nums)):
            if nums[i][1] > arr[-1]:
                arr.append(nums[i][1])
            else:
                index = self.BinarySearch(arr, 0, len(arr), nums[i][1])
                arr[index] = nums[i][1]
        return len(arr)
                
    def BinarySearch(self, arr, low, high, target):
        while low <= high:
            mid = (low + high)//2
            if arr[mid] == target : return mid
            if arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return low
