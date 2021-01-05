class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        # if not envelopes:
        #     return 0
        # envelopes.sort(key= lambda x : x[0]) ###O(nlogn)
        # dp=[1]*len(envelopes)
        # for i in range(len(envelopes)):
        #     for j in range(0,i):
        #         if envelopes[i][1]>envelopes[j][1] and envelopes[i][0]>envelopes[j][0]: #Bug if 0th index values are equal at i and j
        #             dp[i]=max(dp[i],dp[j]+1)  #O(n**2)
        # return max(dp)

        ########### Bisect or BS #########
        # Time-O(nlogn)
        # Space- O(n)
        import bisect
        arr = []
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        for i in range(len(envelopes)):
            l = bisect_left(arr, envelopes[i][1])
            if len(arr) == l:
                arr.append(envelopes[i][1])
            else:
                arr[l] = envelopes[i][1]
        return len(arr)