        
        
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        envelopes.sort(key = lambda x: (x[0], -x[1]))
        arr = [envelopes[0][1]]
        length = 1
        for i in range(1, len(envelopes)):
            value = envelopes[i][1]
            if value>arr[-1]:
                arr.append(value)
                length+=1
            else:
                arr[self.binaryLeft(arr, value)] = value

        return length
    def binaryLeft(self, arr, target):
        
        left = 0
        right = len(arr)-1
        
        while left<=right:
            
            mid = left+(right-left)//2
            
            value = arr[mid]
            if value == target:
                return mid
            elif value<target:
                left = mid+1
            else:
                right = mid-1
        
        return left
Time: NlogN
Space: O(L)
            
