'''
Using DP
Time: O(n^2)
Space: O(n)
Time limit exceeded
'''


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        n = len(envelopes)
        
        dp = [1 for _ in range(n)]
        # sort with any dimension
        envelopes = sorted(envelopes, key = lambda x: (x[0]))
        ma = 1
        for i in range(1, n):
            for j in range(i):
                if envelopes[i][1] > envelopes[j][1] and envelopes[i][0] > envelopes[j][0]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    ma = max(ma, dp[i])
        return ma


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        n = len(envelopes)
        
        dp = [1 for _ in range(n)]
        
        envelopes = sorted(envelopes, key = lambda x: (x[0],-x[1]))
        ma = 1
        for i in range(1, n):
            for j in range(i):
                if envelopes[i][1] > envelopes[j][1]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    ma = max(ma, dp[i])
        return ma




'''
Using Increasing subsequence nlogn logic
Time: O(nlogn)
Space: O(n)
'''

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        n = len(envelopes)
        
        arr = [0 for _ in range(n)]
        
        envelopes = sorted(envelopes, key = lambda x: (x[0],-x[1]))
        
        arr[0] = envelopes[0][1]
        
        len_p = 1
        
        for i in range(1,n):
            if arr[len_p-1] < envelopes[i][1]:
                arr[len_p] = envelopes[i][1]
                len_p += 1
            else:
                bin_ind = self.binarysearch(arr, envelopes[i][1],0,len_p-1)
                arr[bin_ind] = envelopes[i][1]
        
        return len_p
    
    def binarysearch(self, arr, target, l, r):
        while l <= r:
            m = l + (r-l)//2
            if arr[m] == target:
                return m
            elif arr[m] < target:
                l = m + 1
            else:
                r = m - 1
        return l