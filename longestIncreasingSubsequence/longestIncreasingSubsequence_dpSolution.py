'''
Time Complexity: 0(n^n)
Space Complexity: 0(n)
Run on Leetcode: Yes

Approach:
1. Go exhaustive (choose-notChoose) and you will observer the repeating sub-problems with remaining
subset as a deciding parameter
2. Perform 1D memorization to solve this problem

'''
class Solution:
    
    def memorization1D(self,nums,memory1D,maxSize):
        
        # initialize ptrs
        ptrEnd = len(nums)-1
        ptrStart = ptrEnd-1
        
        while ptrStart != -1:
            while ptrEnd != ptrStart:
                if nums[ptrStart] < nums[ptrEnd]:
                    memory1D[ptrStart] = max(memory1D[ptrStart],memory1D[ptrEnd]+1)
                    maxSize = max(maxSize,memory1D[ptrStart])
                ptrEnd -= 1
            '''end of inner while'''
            ptrEnd = len(nums)-1
            ptrStart -= 1
        '''end of outer while'''
        
        # print("MaxSize is:\t",maxSize)
        return maxSize
        
    def lengthOfLIS(self, nums: List[int]) -> int:
        return self.memorization1D(nums, [1]*len(nums), 1)