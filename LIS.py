class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # Time: O(nlogn)
        # Space: O(n)
        # Search for the element that is just greater
        # Binary Search Solution: Non Intuitive
        def binarySearch(arr,target,beg, end):
            while(beg<=end):
                mid = (beg + end)//2
                if(target==arr[mid]):
                    return mid
                elif(target<arr[mid]):
                    end = mid-1
                else:
                    beg = mid+1
            return beg
        
        arr = [0 for i in range(0,len(nums))]
        arr[0] = nums[0]
        length = 1
        for i in range(1, len(nums)):
            if(nums[i]>arr[length-1]):
                arr[length] = nums[i]
                length += 1
            else:
                idx = binarySearch(arr,nums[i],0,length-1)
                arr[idx] = nums[i]
        
        return length
