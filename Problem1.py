#Time Complexity : O(NlogN)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        maxx = 1
        li = []
        low = 1
        li.append(nums[0])
        for i in range(1,len(nums)):
            if nums[i] > li[-1]:
                li.append(nums[i])
            else:
                index = self.binarySearch(0,len(li) - 1,nums[i],li)
                li[index] = nums[i]
                
        return len(li)
    
    def binarySearch(self,low,high,element,li):
        while low <= high:
            mid = (low + high) // 2
            if li[mid] == element:
                return mid
            elif li[mid] > element:
                high = mid - 1
            else:
                low = mid + 1
        return low