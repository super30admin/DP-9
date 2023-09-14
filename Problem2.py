class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        if n == 0:
            return 0

        # Sort the envelopes in ascending order of width and descending order of height
        envelopes.sort(key=lambda x: (x[0], -x[1]))

        # Use binary search to find the index where we can insert each envelope into a sorted list
        dp = []

        for envelope in envelopes:
            left, right = 0, len(dp) - 1

            while left <= right:
                mid = (left + right) // 2
                if dp[mid][1] < envelope[1]:
                    left = mid + 1
                else:
                    right = mid - 1

            if left < len(dp):
                dp[left] = envelope
            else:
                dp.append(envelope)

        return len(dp)