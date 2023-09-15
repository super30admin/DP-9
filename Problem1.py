#Time Complexity :O(nlogn) 
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        result=1
        arr=[]
        arr.append(nums[0])
        length=1
        for i in range(1,len(nums)):
            if nums[i]>arr[-1]:
                arr.append(nums[i])
                length+=1
            else:
                idx=self.binarysearch(arr,0,length-1,nums[i])
                arr[idx]=nums[i]
        return length

    def binarysearch(self,nums,low,high,target):
        while low<=high:
            mid=int((low+high)/2)
            if nums[mid]==target:
                return mid
            elif nums[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return low

        