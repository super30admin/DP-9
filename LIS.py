# Time Complexity : O(NlogN)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        effArr = [-1]*len(nums)
        effArr[0] = nums[0]
        length = 1        
        for i in range(1,len(nums)):
            if nums[i]>effArr[length-1]:
                effArr[length] = nums[i]
                length+=1
            else:
                #put ele to the right pos in effArr
                ind = self.binarySearch(effArr,nums[i],0,length-1)
                effArr[ind] = nums[i]
            
        return length
    
    def binarySearch(self,arr, ele, left, right):
        
        while(left<=right):
            mid = left+(right-left)//2
            if arr[mid]==ele:
                
                return mid
            if arr[mid]>ele:
                right = mid-1
            elif arr[mid]<ele:
                left = mid+1
        return left
    
    
                
            