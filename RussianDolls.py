#All TC passed on leetcode


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:

        #Here we sort the envelopes based on weight (can be done on height as well) and then perform longest increasing subsequence approach on height using binary search.
        #Time complexity - O(nlogn) 
        #Space complexity - O(n) - for storing the longest subsequence
        maxLen = 1
        n = len(envelopes)

        envelopes.sort(key=lambda x: (x[0], -x[1]))

        arr = []
        arr.append(envelopes[0][1])

        for i in range(1,n):
            if envelopes[i][1]>arr[-1]:
                arr.append(envelopes[i][1])
            else:
                idx = self.getRightIndex(envelopes[i][1], arr)
                arr[idx] = envelopes[i][1]

        return len(arr)

    def getRightIndex(self, target, arr):
        l=0
        h=len(arr)-1

        while l<=h:
            mid = (l+h)//2

            if target == arr[mid]:
                return mid
            elif target>arr[mid]:
                l = mid+1
            else:
                h = mid-1
        return l



#----------------------------------------------OR------------------------------------------------

        #Here we sort the envelopes based on weight (can be done on height as well) and then perform longest increasing subsequence approach on height.
        #Time complexity - O(nlogn + n^2) 
        #Space complexity - O(n) - for storing dp array
        maxLen = 1
        n = len(envelopes)
        dp = [1]*n

        envelopes.sort(key=lambda x: (x[0], -x[1]))
        print(envelopes)            

        for i in range(1,n):
            for j in range(i):
                if envelopes[i][1]>envelopes[j][1]:
                    dp[i] = max(dp[i], 1+dp[j])
                    maxLen = max(maxLen, dp[i])
        return maxLen

