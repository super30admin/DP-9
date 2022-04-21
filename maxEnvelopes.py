class Solution:
    '''
    Algorithm : Sort + Longest Increasing Subsequence
    '''
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        """Binary search approach
        Time complexity-O(nlogn)
        Space complexity-O(n)"""
        envelopes.sort(key=lambda x: (x[0],-x[1]))
        arr=[envelopes[0]]
        for i in range(1, len(envelopes)):
            if envelopes[i][0]>arr[-1][0] and envelopes[i][1]>arr[-1][1]:
                arr.append(envelopes[i])
            else:
                index=self.searchIndexforGreaterELeinArr(arr, 0, len(arr)-1, envelopes[i][1])
                if index>len(arr)-1:
                    arr.append(envelopes[i])
                else:
                    arr[index]=envelopes[i]
        return len(arr)
    
    def searchIndexforGreaterELeinArr(self, newArr, low, high, element):
        while low<=high:
            mid=low+(high-low)//2
            if newArr[mid][1]==element:
                return mid
            if newArr[mid][1]>element:
                high=mid-1
            else:
                low=mid+1
        return low
    
    def TopDownmaxEnvelopes(self, envelopes: List[List[int]]) -> int:
        '''
        T = O(N^2)
        S = O(N)
        '''
        envelopes.sort()
        n = len(envelopes)
        dp = [1]*n
        for i in range(1, n):
            for j in range(i):
                if envelopes[i][0] > envelopes[j][0]:
                    if envelopes[i][1] > envelopes[j][1]:
                        dp[i] = max( dp[i] ,   dp[j] + 1 )
        return max(dp)
    
    
