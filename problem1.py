class Solution:
    # binary search approach
    # TC : O(nlog(n))
    # SC : O(n)
    def binarySearch(self,nums,low,high,target):
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                low = mid +1
            else:
                high = mid - 1
        return low
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums is None:
            return 0
        n = len(nums)
        res = [0]*n
        res[0] = nums[0]
        lenv = 1
        for i in range(1,n):
            if nums[i] > res[lenv-1]:
                res[lenv] = nums[i]
                lenv += 1
            else:
                bsindex = self.binarySearch(res,0,lenv-1,nums[i])
                res[bsindex] = nums[i]
        return lenv
                