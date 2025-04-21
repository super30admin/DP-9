"""
DP Approach --
TC - O(n^2)
SC - O(n) ==> The only extra space we use relative to input size is the dp array, which is the same length as nums

Optimized Binary Search Approach --
TC - O(n log n)
SC - O(n)
"""
class Solution:
    def binarySearch(self, arr, target, low, high):
        while low <= high:
            mid = low + (high-low) // 2
            if arr[mid] == target: return mid
            elif target < arr[mid]: high = mid - 1
            else: low = mid + 1
        return low # if nothing found return low ==> dry run [0,1,0,3,2,3] test case for why

    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0: return 0

        n = len(nums)
        arr = [0 for i in range(n)]
        arr[0] = nums[0]

        arrlen = 1

        # we start from 1 sinnce num[0]th element is already added in arr
        for i in range(1, n):
            # example - compare nums[1] with arr[0]
            if nums[i] > arr[arrlen-1]:
                # arr[len] ==> next index after the above compared element
                arr[arrlen] = nums[i]
                arrlen += 1
            else:
                idx = self.binarySearch(arr, nums[i], 0, arrlen-1)
                arr[idx] = nums[i]

        return arrlen