
"""
At each index we have two choices choose, no choose, 
choose case is availablke only when the number is greater than prev number.

Binary search. Maintain a effective sub array, each time a smaller numebr is encountered, replace the just greater number in the effective array, Otherwise if current number is bigger than the last adeed number, simply append
Tc: O(nlogn)
SP: O(n)
"""



class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        arr = [nums[0]]
        subsequence = [nums[0]]
        ln = 1
        for i in range(1, len(nums)):
            just_greater_idx = bisect.bisect_left(arr, nums[i])
            if just_greater_idx >= ln:
                arr.append(nums[i])
                subsequence.append(nums[i])
                ln += 1
            else:
                arr[just_greater_idx] = nums[i]
                subsequence[just_greater_idx] = nums[i]
        return ln
