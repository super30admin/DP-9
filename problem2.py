# Time Complexity : O(nlogn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key = lambda x:(x[0],-x[1]))
        return self.lengthOfLIS([x[1] for x in envelopes])
    
    def lengthOfLIS(self, nums: List[int]) -> int:
        effective = [nums[0]]
        for i in range(1, len(nums)):
            target_ix = self.bin_search(effective, nums[i])
            if target_ix != len(effective):
                effective[target_ix] = nums[i]
            else:
                if nums[i] != effective[-1]:
                    effective.append(nums[i])

        return len(effective)
    
    def bin_search(self, arr, target):
        l,r = 0, len(arr)
        while l < r:
            mid = l + (r-l)//2
            if arr[mid] <= target:
                l = mid + 1
            else:
                r = mid
        if arr[l-1] == target:
            return l-1

        return l