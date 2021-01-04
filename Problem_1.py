"""
Time Complexity : O(nlogn) for optimal solution and O(n^2) for DP solution
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Here, for DP solution, we would be iterating through the array and checking at every point, if we have values lesser than the 
current value. And if we have, how many. We do this by maintaining a DP array and initialising it by 1, as in worst case, all
the values would be in descending order and we would be having maximum length of 1 for increasing subsequence, that would be the 
number itself. So, we would be iterating from 1st index till last, and every time, we would check from 0th location till i,
if we have value lesser than current. If yes, we would just check its value in DP array, add one to it and compare with DP array 
value at current position. We want to take maximum of the values to maintain maximum length of subsequence. This solution is 
of n^2 complexity. To make it optimal, we would perform binary search. Here, we would be maintaining an array where the values
are in sorted order and would add the first value as first index value of the array. To begin with, we would be starting with
the first index, we would keep on checking if the current value is greater than the last value of temp array. If yes, we just
append the value to temp array, this would maintain the logest increasing subsequence. In case, the value is smaller, we need
to find the position were this number could be inserted to maintain sorted order, that would be done by binary search. Once we 
reach end of the traversal, the length of the temp array would be the length of longest increasing subsequence and the 
temp array itself would be the longest increasing subsequence.
"""


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        length = len(nums)
        effBSArr = []
        effBSArr.append(nums[0])
        for i in range(1, length):
            if nums[i] > effBSArr[-1]:
                effBSArr.append(nums[i])
            else:
                position = self.binarySearch(
                    effBSArr, 0, len(effBSArr)-1, nums[i])
                effBSArr[position] = nums[i]
        return len(effBSArr)

    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low+(high-low)//2
            if arr[mid] == target:
                return mid
            if arr[mid] > target:
                high = mid-1
            else:
                low = mid+1
        return low

# class Solution:
#     def lengthOfLIS(self, nums: List[int]) -> int:
#         if not nums:
#             return 0
#         max_=1
#         length=len(nums)
#         dp=[1 for _ in range(length)]
#         for i in range(1,length):
#             for j in range(0,i):
#                 if nums[j]<nums[i]:
#                     dp[i]=max(dp[i],dp[j]+1)
#                     max_=max(dp[i],max_)
#         return max_
