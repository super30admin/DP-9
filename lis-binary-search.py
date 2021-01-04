# Binary Search Approach
# Time Complexity: O(n log n)
# Space Complexity: O(n)
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Initialize auxillary array to save longest subsequence so far
        aux = [nums[0]]
        
        # For every number in nums
        for i in range(len(nums)):
            # if num > last element of aux, append it to aux
            if nums[i] > aux[-1]:
                aux.append(nums[i])
            # else find the index of number that is just greater than nums[i] in the aux array and insert nums[i] at that index
            else:
                idx = bisect.bisect_left(aux, nums[i], 0, len(aux)-1)
                aux[idx] = nums[i]
        
        return len(aux)