'''
Time Complexity: O(n^2)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Sort the envelopes based on any key either height or width. After we sort the array the question comes
down to same as longest Increasing Subsequence.

We have 2 choices here either take the number or not to take the number in a recursive implementation
start from the beginning and create an output array of all 1's. for index i check if index j from index i till 0 there
exists an index where the width of the ith envelop should be greater than of the jth envelope and the height of the ith
envelop should be greater than the height of the jth if it is then output[i] = max(output[i], output[j]+1) the +1 is the
increase the new term contributes to the increasing subsequence. Create a max variable to keep track of max value at the
end of the j loop instead of finding max value in the output array

eg      [[5,4],[6,4],[6,7],[2,3]]
sort    [[2, 3], [5, 4], [6, 4], [6, 7]]
output      1       2       2       3
'''
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
          """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        n = len(envelopes)
        if n < 2:
            return n
        envelopes.sort()
        ans = 1
        dp = [1 for i in range(n)]
        for i in range(1, n):
            for j in range(i):
                if envelopes[i][0] > envelopes[j][0] and envelopes[i][1] > envelopes[j][1]:
                    dp[i] = max(dp[i], dp[j]+1)
            ans = max(ans, dp[i])
        return ans