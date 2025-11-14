# Time complexity: O(n^2). Space is O(n) using the dp array

# Intuition is to create a dp array and then mark it as 1 for each element as each is subsequence of its own.
# Then we try to find the next subsequence if the ith value is greater than the jth value.
from typing import List
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1] * (n+1)
        for i in range(1, n):
            for j in range(0,i+1):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], 1 + dp[j])

        return max(dp)


    # This is an efficient solution as we are keeping track of the effective increasing subsequence, whenever we find a value that is greater than the last value in the eff inc sub
    # we append it, otherwise we find the next higher interger in the effIncSub and replace with the current value, in the end we can return the length which would be the lenght of LIS
    # The time complexity is O(nlogn)
    def lengthOfLISBinarySearch(self, nums: List[int]) -> int:
        n = len(nums)
        effIncSub = []
        effIncSub.append(nums[0])
        for i in range(1, n):
            if nums[i] > effIncSub[-1]:
                effIncSub.append(nums[i])
            else:
                bsIdx = self.binarySearch(effIncSub, nums[i])
                effIncSub[bsIdx] = nums[i]
        return len(effIncSub)

    def binarySearch(self, effIncSubArr, target):
        left = 0
        right = len(effIncSubArr) - 1

        while left < right:
            mid = left + (right - left) // 2
            if effIncSubArr[mid] == target:
                return mid
            elif effIncSubArr[mid] > target:
                right = mid
            else:
                left = mid + 1
        return left