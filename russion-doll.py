class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        n = len(envelopes)
        dp = [0]*n
        dp[0] = envelopes[0][1]
        curr_len = 1
        for i in range(1, n):
            if envelopes[i][1] > dp[curr_len-1]:
                dp[curr_len] = envelopes[i][1]
                curr_len += 1
            else:
                idx = self.binarySearch(envelopes[i][1], dp, 0, curr_len-1)
                dp[idx] = envelopes[i][1]
        return curr_len

    def binarySearch(self, val, dp, low, high):
        while low <= high:
            mid = (low+high)//2
            if dp[mid] == val:
                return mid
            elif(val > dp[mid]):
                low = mid+1
            else:
                high = mid-1
        return low
