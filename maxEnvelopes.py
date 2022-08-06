# Time Complexity : O(nlogn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:

        envelopes.sort(key=lambda x: (x[0], -x[1]))

        dp = [envelopes[0][1]]

        for i in range(1, len(envelopes)):
            if envelopes[i][1] > dp[-1]:
                dp.append(envelopes[i][1])
            elif envelopes[i][1] <= dp[0]:
                dp[0] = envelopes[i][1]
            else:
                left = 0
                right = len(dp) - 1
                while left <= right:
                    mid = left + (right - left) // 2
                    if left == right or dp[mid] < envelopes[i][1] and dp[mid + 1] >= envelopes[i][1]:
                        dp[mid + 1] = envelopes[i][1]
                        break
                    elif dp[mid] < envelopes[i][1]:
                        left = mid + 1
                    else:
                        right = mid - 1

        return len(dp)
