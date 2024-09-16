'''
Accepted on leetcode(300)
Time - O(N^2)
Space - O(N)
Approach:
1. Initialize dp array and retval. Handle edge cases.
2. Iterate over each element and check at every element the number of values in increasing order. If some of them are calculated in dp array take the max of it and use it for further calculation.
3. After each loop of j, reinitialize maxsub and add the value of maxsub to ith position in dp array before reinitializing which number is the maxsubsequence at that index.
4. return final answer from dp array, max of dp array.
'''


class Solution:
    def lengthOfLIS(self, nums) -> int:
        # edge case
        if len(nums) == 0:
            return 0
        # filling dp array same as length of nums array.
        dp = [1 for i in range(len(nums))]
        # initialize final answer to return at end.
        retVal = 1
        # start 2 loops one inside another(nested)
        for i in range(len(nums)):
            maxsub = 0
            for j in range(0, i):
                if nums[i] > nums[j]:
                    maxsub = max(maxsub, dp[j])
            dp[i] = dp[i] + maxsub
            retVal = max(dp[i], retVal)

        return retVal