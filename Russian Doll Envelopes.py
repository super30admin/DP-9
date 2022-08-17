# time complexity is o(nlog(n)), where n is the size of the input
# space complexity is o(n),  where n is the size of the input
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        newEnvelops = sorted(envelopes, key = lambda x: (x[0], -x[1])) # space o(n)
        # print(newEnvelops)
        arr = [0 for i in range(len(envelopes))] # space o(n)
        arr[0] = newEnvelops[0][1]
        l = 1
        for i in range(1, len(envelopes)): # time o(n)
            if(newEnvelops[i][1] > arr[l - 1]):
                arr[l] = newEnvelops[i][1]
                l += 1
            else:
                bsIndex = self.binarySearch(arr, 0, l-1, newEnvelops[i][1]) # time o(log(n))
                arr[bsIndex] = newEnvelops[i][1]
        return l
                
                
    def binarySearch(self, arr, low, high, target):
        while(low <= high):
            mid = low + (high - low)//2
            if(arr[mid] == target):
                return mid
            elif(arr[mid] > target):
                high = mid - 1
            else:
                low = mid + 1
        return low
        
        
        
        
        
        
        
        
        # time limit exceed solution
        # envelopes.sort()
        # dp = [1 for i in range(len(envelopes))]
        # maxCount = 1
        # for i in range(1, len(envelopes)):
        #     for j in range(0, i):
        #         if(envelopes[i][1] > envelopes[j][1] and 
        #            envelopes[i][0] > envelopes[j][0]):
        #             dp[i] = max(dp[i], 1 + dp[j])
        #             maxCount = max(dp[i], maxCount)
        # return maxCount
                    
 