#354. Russian Doll Envelopes
#time complexity: O(nlogk)
#space complexity: O(n)

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key = lambda x: (x[0],-x[1]))
        n = len(envelopes)
        dp = [0 for _ in range(n)]
        dp[0] = envelopes[0][1]
        lens = 1

        for i in range(1,n):
            if(dp[lens-1] < envelopes[i][1]):
                dp[lens] = envelopes[i][1]
                lens+=1

            else:
                idx = self.binarySearch(dp,envelopes[i][1],0,lens)
                dp[idx] = envelopes[i][1]
        return lens


    def binarySearch(self,arr,target,low,high):
        while(low<=high):
            mid = low + (high-low)//2
            if(arr[mid]==target): return mid
            if(arr[mid] < target):
                low = mid+1
            else:
                high = mid -1
        return low
