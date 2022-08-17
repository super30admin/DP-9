# time complexity is o(n(logn)), where n is the size of the input
# space complexity is o(n),  where n is the size of the input
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        arr = [0 for i in range(len(nums))] # space n 
        arr[0] = nums[0] 
        l = 1
        for i in range(len(nums)): # time n
            if(nums[i] > arr[l-1]):
                arr[l] = nums[i]
                l += 1
            else:
                bsIndex = self.binarySearch(arr, 0, l-1, nums[i]) # time log(n)
                arr[bsIndex] = nums[i]
        return l
    
    def binarySearch(self, arr, low, high, target):
        while(low <= high):
            mid = low + (high - low)//2
            if(arr[mid] == target):
                return mid
            elif(arr[mid] > target):
                high = mid - 1
            else:
                low = mid + 1
        return low
                
            
        
        
        
        
        
        
        # time is o(n^2)
        # space is o(n)
        # dp = [1 for i in range(len(nums))]
        # maxVal = 1
        # for i in range(len(nums)):
        #     for j in range(0, i):
        #         if(nums[i] > nums[j]):
        #             dp[i] = max(dp[i], 1 + dp[j])
        #             maxVal = max(maxVal, dp[i])
        # return maxVal
            