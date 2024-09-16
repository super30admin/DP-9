'''
TLE on leetcode(354)
Time - O(N^2)
Space - O(N)

'''


class Solution:
    def maxEnvelopes(self, envelopes) -> int:
        # edge case
        if len(envelopes) == 0:
            return 0
        # sort the envelopes by width
        envelopes.sort(key=lambda x: x[0])

        # create a dp array of same length as envelopes.
        dp = [1 for i in range(len(envelopes))]

        # return count
        retVal = 1

        # nested loop
        for i in range(len(envelopes)):
            maxSub = 0
            for j in range(0, i):
                # check if both height and width are greater than the previous element, then increment the count of subsequence.
                if envelopes[i][0] > envelopes[j][0] and envelopes[i][1] > envelopes[j][1]:
                    maxSub = max(maxSub, dp[j])

            dp[i] = dp[i] + maxSub
            retVal = max(retVal, dp[i])

        return retVal