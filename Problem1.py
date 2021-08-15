# Time Complexity : O(nlogn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# basically finding the longest possible by using an array and when we encounter a
# value greater than last append else find the position of that particular element using binary search
# and replace the value
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        arr = [0]*len(nums)
        
        pos = 1
        arr[0] = nums[0]
        
        for i in range(1,len(nums)):
            if nums[i] > arr[pos-1]:
                arr[pos] = nums[i]
                pos += 1
            else:
                bsIndex = self.binarySearch(arr,0,pos-1,nums[i])
                
                arr[bsIndex] = nums[i]
                # pos = bsIndex + 1
        
        return pos
    
    def binarySearch(self,arr,l,h,t):
            
            while l <= h:
                mid =  (l + h)//2
                
                if arr[mid] == t:
                    return mid
                elif arr[mid] > t:
                    h = mid - 1
                else:
                    l = mid + 1
            return l
                
        
        