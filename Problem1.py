"""
I implemented a solution to find the length of the Longest Increasing Subsequence (LIS). I used a greedy approach with binary search to keep the sequence as small as possible. If the current number is bigger than the last in the result list, I add it. Otherwise, I replace the first number in result that is greater or equal to it. The final length of the result list is the length of the LIS.
Time Complexity: O(nlogn)
Space Complexity: O(n)
"""
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        result = []
        def binarySearch(result, num):
            left = 0
            right = len(result) - 1
            while left <= right:
                mid = (left + right) // 2
                if result[mid] == num:
                    return mid
                elif result[mid] > num:
                    right = mid - 1
                else:
                    left = mid + 1
            return left
        
        for num in nums:
            if not result or result[-1] < num:
                result.append(num)
            else:
                index = binarySearch(result, num)
                result[index] = num
        return len(result)