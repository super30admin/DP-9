"""
Time complexity O(N Log N )
Space complexity O(N)



"""

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        arr=[0 for _ in range(len(nums))]
        arr[0]=nums[0]
        idx=1
        for i in range(1,len(nums)):
            if(nums[i]>arr[idx-1]):
                arr[idx]=nums[i]
                idx+=1
            else:
                bIdx=self.binarysearch(arr,0,idx-1,nums[i]) #to find index of the next highest element of nums[i] in arr[]
                arr[bIdx]=nums[i]
        
        return idx
    
    def binarysearch(self,arr,l,h,target): 
        while l<=h: #closest binary search 
            mid=l+(h-l)//2
            if arr[mid]==target:
                return mid
            elif arr[mid]>target:
                h=mid-1
            else:
                l=mid+1
        return l
        