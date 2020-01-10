#time  =  o(log n ** 2)
#leetcode - 354
#logic : Create a dp array with max number of elements that can be formed following the rule(both height and width) and use that to find the next elemnts max count and finally giveout the highest subsequence value
#time limit exceeded error
class Solution:

    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:

        # edge case
        if len(envelopes) == 0:
            return 0
        # variables
        dp = [1 for i in range(len(envelopes))]
        envelopes.sort(key=lambda x:x[0]) #inplace function
        # return variables
        ret_val = 1
        max_sub_sequence = 0
        # logic
        for i in range(1,len(envelopes)):
            for j in range(i):
                if envelopes[i][0] > envelopes[j][0] and envelopes[i][1] > envelopes[j][1]:
                    # if dp[j] > max_sub_sequence:
                    max_sub_sequence = max(dp[j], max_sub_sequence)
            dp[i] = dp[i] + max_sub_sequence  # since the intial vaule in dp array is 1
            ret_val = max(ret_val, dp[i])
            max_sub_sequence = 0
        return ret_val