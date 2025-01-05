class Solution:
    def maxEnvelopes(self, envelopes):

        envelopes.sort(key=lambda x: (x[0], -x[1]))

        heights = [envelope[1] for envelope in envelopes]

        dp = []

        for h in heights:

            pos = self.binary_search(dp, h)

            if pos == len(dp):

                dp.append(h)
            else:

                dp[pos] = h

        return len(dp)

    def binary_search(self, dp, target):

        low, high = 0, len(dp) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if dp[mid] == target:
                return mid
            elif dp[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return low
