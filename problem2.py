# TC:O(n log n)
# SC:O(n)


class Solution:
    def custm_sort(self,a,b):
        if a[0] == b[0]:
            return b[1] - a[1]
        return a[0]-b[0]

    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if envelopes is None or len(envelopes) == 0:
            return 0

        n = len(envelopes)

        envelopes = sorted(envelopes, key=functools.cmp_to_key(self.custm_sort))

        dp = [0] * n
        _len = 1
        dp[0] = envelopes[0][1]

        for i in range(1,n):
            if dp[_len-1] < envelopes[i][1]:
                dp[_len] = envelopes[i][1]
                _len += 1

            else:
                idx = self.binarysearch(dp,envelopes[i][1],0,_len-1)
                dp[idx] = envelopes[i][1]

        return _len



    def binarysearch(self,dp,num,low,high):
        while low <= high:
            mid = int(low + (high - low)/2)

            if dp[mid] == num:
                return mid
            elif dp[mid] > num:
                high = mid -1
            else:
                low = mid+1

        return low
