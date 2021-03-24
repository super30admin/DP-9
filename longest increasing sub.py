"""
Time Complexity : O()
Space Complexity : O()
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
Use the sam etechnique as russian doll
iterate over the list and look if the current element is greater than the top of the 
resultant list
if it is then increase count if it is not then find the index using binary saerch and put that in res list

"""

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums == None: return 0
        n = len(nums)
        arr = [0]*n
        mx = 0
        arr[0] = nums[0]
        ln = 1
        
        for i in range(1, len(nums)):
            if nums[i] > arr[ln-1]:
                arr[ln] = nums[i]
                ln += 1
            else:
                index = self.binarySearch(arr, 0, ln, nums[i])
                arr[index] = nums[i]
        print(arr)
        return ln
            
    def binarySearch(self, arr, low, high, target):
        
        while low<=high:
            mid = (low + high)//2
            if arr[mid] == target : return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return low