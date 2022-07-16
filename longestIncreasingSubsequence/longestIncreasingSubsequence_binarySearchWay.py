'''
Time Complexity: 0(nlogn) -- binary search
Space Complexity: 0(n)
Run on Leetcode: Yes

Approach:
1. Create an effective array
2. If current value is greater than the effective array's last value, simply 
append the current value to the stack
3. Else, perform binary-search in the effective-nums array that replaces the current 
value 'in-place'
'''
class Solution:
    
    def __init__(self):
        self.effectiveNums = []
        
    
    def binarySearch(self,low,high,target):
        
        while low <= high:
            mid = (high-low)//2 + low
            
            if self.effectiveNums[mid] == target:
                self.effectiveNums[mid] = target
                return
            
            elif self.effectiveNums[mid] < target:
                low = mid+1
            
            elif self.effectiveNums[mid] > target:
                high = mid-1
        '''end of while loop'''
        self.effectiveNums[low] = target
        return 
    
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        self.effectiveNums.append(nums[0])
        
        # iterate the nums from index 1
        for i in range(1,len(nums)):
            # compare with the last index of effective nums
            if self.effectiveNums[-1] < nums[i]:
                self.effectiveNums.append(nums[i])
            else:
                # perform binarySearch
                self.binarySearch(0,len(self.effectiveNums)-1,nums[i])
        '''end of nums iteration'''
        # print("Longest count is:\t",len(self.effectiveNums))
        return len(self.effectiveNums)