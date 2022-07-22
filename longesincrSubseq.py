'''
time complexity: O(nlogk)
space complexity: O(n)
'''
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        arr = [0 for _ in range(n)]
        
        arr[0] = nums[0]
        lens = 1
        for i in range(1,n):
            if(arr[lens-1] < nums[i]):
                arr[lens] = nums[i]
                lens+=1
            else:
                idx = self.binarySearch(arr,nums[i],0,lens)
                arr[idx] = nums[i]
        return lens
    def binarySearch(self,arr,target,low,high):
        while(low<=high):
            mid = low + (high-low)//2
            if(arr[mid]==target): return mid
            elif(arr[mid] > target):
                high = mid - 1
            else:
                low = mid+1
        return low
        