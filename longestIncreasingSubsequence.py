'''
Time Complexity: O(n^2)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: We have 2 choices here either take the number or not to take the number in a recursive implementation
start from the beginning and create an output array of all 1's. for index i check if index j from index i till 0 there
exists an index where nums[i]> nums[j] if it is then output[i] = max(output[i], output[j]+1) the +1 is the increase the
new term contributes to the increasing subsequence. Create a max variable to keep track of max value at the end of the j loop
instead of finding max value in the output array

eg      10 9 2 5 3
output  1  2 1 2 2
'''
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        output = [1 for i in range(len(nums))]

        n = len(nums)

        maxLen = 0
        for i in range(0, n):
            for j in range(i - 1, -1, -1):
                if nums[i] > nums[j]:
                    output[i] = max(output[i], output[j] + 1)
            maxLen = max(maxLen, output[i])

        return maxLen