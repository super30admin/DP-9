"""
    
        Name : Shahreen Shahjahan Psyche
        Time : Brute Force  : O(2^N)
               Dynammic     : O(N^2)
               Binary Search: O(NlogN)
               
        Space: Brute Force  : O(N) [Stack Space]
               Dynammic     : O(N) [DP Array]
               Binary Search: O(N) [Auxiliary Array]
        
        Passed All Test Cases in LC : Yes - (Binary and Dynammic)
        
        Approach : Brute Force: # It takes all the routes into account by having 2 options. Choose the current element or not. We only choose the current elemeent                                   when its bigger than the previous value and increase the length of the maximum subsequence by 1. In the end, we return the 
                                  maximum subsequence. 
                   Dynammic   : # We create an auxiliary data structure array which is the size of the nums array. Our goal is to get the maximum subsequence for                                   the current element while travarsing the 'nums' array. 
                   Binary.    : # Here also we create an auxiliary data structure array of nums size. Then, in the first place of the new array, we copy the first
                                  element of nums. Then wee start the loop which travarse thee nums array. We initiate a length variable. Now, if the current                                       value is greater than the value in track which is in length position, then we add the value to length position of track and                                       increase lenth by 1. Otherwise, inside track we find the position using binary search where the previous value of track is                                         smaller than the current value. We replace the value inside track with current value. At the end we return the length
    
"""


class Solution:
    
    # brute force solutioon - 1
    def bruteForceOne(self, nums, index, max_len):
        if index == len(nums):
            return max_len
        size = max_len
        for i in range(index+1, len(nums)):
            if nums[index] < nums[i]:
                temp = max(max_len, self.bruteForce(nums, i, max_len+1))
                if size < temp:
                    size = temp
        
        return size
            
    # Choose/Not Choose
    def bruteForceTwo(self, nums, prev_val, index):
        
        if index == len(nums):
            return 0
        
        case_zero = self.bruteForceTwo(nums, nums[index], index+1)
        case_one = 0
        if prev_val < nums[index]:
            case_one = 1 + self.bruteForceTwo(nums, nums[index], index+1)
        return max(case_zero, case_one)
        
    def dynammicSolution(self, nums):
            
        track = [1 for i in range(len(nums))]
        records = {}
        for i in range(len(nums)):
            records[i] = []
            records[i].append(nums[i])
        max_val = 1
        for i in range(1, len(track)):
            for j in range(0, i):
                if nums[i] > nums[j]:
                    track[i] = max(track[i], 1+track[j])
                    records[i] = list(records[j])
                    records[i].append(nums[i])
                    if track[i] > max_val:
                        max_val = track[i]
        # Trying to see whether I can get the longest subsequencee as well with the leength        
        print(records)
        return max_val
    
    def _binarySearch(self, track, length, target):
        start = 0
        end = length - 1
        while start <= end:
            mid = start + (end - start)//2
            if track[mid] == target:
                return mid
            elif track[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return start
        
    def binarySearchSolution(self, nums):
        track = [0 for i in range(len(nums))]
        track[0] = nums[0]
        length = 1
        for i in range(1, len(nums)):
            if nums[i] > track[length-1]:
                track[length] = nums[i]
                length += 1
            else:
                pos = self._binarySearch(track, length, nums[i])
                track[pos] = nums[i]
        return length
        
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        
        
        initial = 1
        max_len = float('-inf')
        index = 0
        
        # for i in range(len(nums)):
        #     max_len = max(max_len, self.bruteForceOne(nums, i, initial))
        
        # max_len = self.bruteForceTwo(nums, float('-inf'), 0)
        max_len = self.dynammicSolution(nums)
        max_len = self.binarySearchSolution(nums)
        
        return max_len
        
