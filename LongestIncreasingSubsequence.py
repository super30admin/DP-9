class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        """Binary search Approach
        Time complexity-O(nlogn)
        Space complexity-O(n)"""
        arr=[0 for i in range(len(nums))]
        length=1
        arr[0]=nums[0]
        for i in range(1,len(nums)):
            if nums[i]>arr[length-1]:
                arr[length]=nums[i]
                length+=1
            else:
                index=self.searchIndexforGreaterELeinArr(arr, 0, length-1, nums[i])
                arr[index]=nums[i]
        return length
    
    def searchIndexforGreaterELeinArr(self, newArr, low, high, element):
        while low<=high:
            mid=low+(high-low)//2
            if newArr[mid]==element:
                return mid
            if newArr[mid]>element:
                high=mid-1
            else:
                low=mid+1
        return low
            
                
            
        """Top Down approach
        Time complexity-O(n^2)
        Space complexity-O(n)where n is the length of the nums list"""
        # dparr=[1 for i in range(len(nums))]
        # maxi=1
        # for i in range(1, len(nums)):
        #     for j in range(i):
        #         if nums[i]>nums[j]:
        #             dparr[i]=max(dparr[i], dparr[j]+1)
        #             maxi=max(dparr[i], maxi)
        # return maxi
        """Bottom Up Approach DP
        Time complexity-O(n^2)
        Space complexity-O(n)"""
        # dparr=[1 for i in range(len(nums))]
        # maxi=1
        # for i in range(len(nums)-2, -1, -1):
        #     for j in range(i+1, len(nums)):
        #         if nums[i]<nums[j]:
        #             dparr[i]=max(dparr[i], dparr[j]+1)
        #             maxi=max(dparr[i], maxi)
        # return maxi
            