#Time: O(N^2)
#Space: O(N)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums == None or len(nums)==0:
            return 0

        dp = [1]*len(nums)
        for i in range(1,len(nums)):
            for j in range(0, i):
                if nums[i]>nums[j]:
                    dp[i] = max(dp[i], 1+dp[j])

        return max(dp)
    
#Binary Seach method

#Time: O(nlogn)
#Space: O(N)
class Solution:
    
    def binarySearch(self,nums,low,high,target):
            while low<=high:
                mid = (low+high)//2
                if nums[mid]==target:
                    return mid
                elif nums[mid] > target:
                    high = mid-1
                else:
                    low = mid+1
            return low
   
    
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        if nums == None or len(nums)==0:
            return 0   
        

        arr = [0]*len(nums)
        lenn=0
        arr[0] = nums[0]
        lenn+=1
        for i in range(len(nums)):
            if nums[i]>arr[lenn-1]:
                arr[lenn]=nums[i]
                lenn+=1
            else:
                bindex = self.binarySearch(arr,0,lenn-1,nums[i])
                arr[bindex] = nums[i]

        return lenn
                
