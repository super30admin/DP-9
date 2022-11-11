#Time: O(nlogn)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    
    def binarySearch(self, arr, l, h, t):
        while (l <= h):
            m = int(l + (h - l)/2)
            if arr[m] == t:
                return m
            elif arr[m] > t:
                h = m - 1
            else:
                l = m + 1
        
        return l
            
        
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        arr = [0] * n
        arr[0] = nums[0]
        res = 1
        for i in range(1, n):
            if nums[i] > arr[res-1]:
                arr[res] = nums[i]
                res += 1
            else:
                bsIx = self.binarySearch(arr, 0, res -1, nums[i])
                arr[bsIx] = nums[i]
        
        return res
                
        