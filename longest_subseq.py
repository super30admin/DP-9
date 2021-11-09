
#Time Complexity : O(n^2)
#Space Complexity : O(n log n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def bsearch(self, val, li, l, h):
        while l<=h:
            m = int((l+h)/2)
            if li[m] == val:
                return m
            elif li[m] > val:
                h = m-1
            else:
                l = m+1
        return l
                
        
    def lengthOfLIS(self, nums: List[int]) -> int:
        li = [nums[0]]
        j = 0
        k = 1
        for i in range(1, len(nums)):
            if nums[i] > li[k-1]:
                li.append(nums[i])
                k += 1
            else:
                j = self.bsearch(nums[i], li, 0, k-1)
                li[j] = nums[i]
        return k

        