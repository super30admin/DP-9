'''
Time Complexity : O(nlogn) for optimal solution and O(n^2) for DP solution
Space Complexity : O(n)
'''

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        if not envelopes:
            return 0
        
        envelopes = sorted(envelopes, key=lambda x: (x[0], -x[1]))
        
        bsArray = []
        bsArray.append(envelopes[0][1])
        
        for i in range(1,len(envelopes)):
            if envelopes[i][1] > bsArray[-1]:
                bsArray.append(envelopes[i][1])
            else:
                pos = self.binarySearch(bsArray, 0, len(bsArray)-1, envelopes[i][1])
                bsArray[pos] = envelopes[i][1]
        print(envelopes)      
        return len(bsArray)
                
        
        
        
    def binarySearch(self, arr, low, high, target):
        while(low<=high):
            mid = low + (high - low)//2
            
            if arr[mid] == target:
                return mid
            if arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
                
        return low

        
        
        
'''
        if not envelopes:
            return 0
        
        envelope = sorted(envelopes)
        l = len(envelopes)
        dp = [1 for _ in range(l)]

        m = 1
        for i in range(1,l):
            for j in range(0,i):
                if envelope[i][1] > envelope[j][1] and envelope[i][0] > envelope[j][0]:
                    dp[i] = max(dp[i], dp[j]+1)
                    m = max(m,dp[i])

        return m
''' 