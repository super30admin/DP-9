'''
Time Complexity - O(nlogn), O(n^2) fpr DP
Space Complexity - O(n). we are using 1 array to maintain the LIS and also for DP
Works on Leetcode
'''
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        #USING DP
        # LIS = [1] * len(nums)
        # for i in range(len(nums) - 1, -1, -1):
        #     for j in range(i+1, len(nums)):
        #         if nums[i] < nums[j]:
        #             LIS[i] = max(LIS[i], 1+LIS[j])
        # return max(LIS)

        #Using Binary Search
        n = len(nums)
        arr = [0] * n
        #store 1st index in the result
        arr[0] = nums[0]
        #ptr to point next empty index in arr
        le = 1
        for i in range(1, n):
            #if we get a number in nums greater than last element in arr, append to arr and move le
            if nums[i] > arr[le-1]:
                arr[le] = nums[i]
                le+=1
            #else find next greater number in arr than nums[i] using binary searchand replace
            else:
                bsIndex = self.binarySearch(arr, nums[i], 0, le - 1)
                arr[bsIndex] = nums[i]
        return le

    def binarySearch(self, arr, target, low, high):
        #classic binary search
        while low <= high:
            mid = low + (high-low)//2
            if target == arr[mid]:
                return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low
