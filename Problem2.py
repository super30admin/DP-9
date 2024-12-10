# Problem 2: Russian Doll Envelopes
from typing import List
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        arr = [0 for _ in range(n)]
        envelopes.sort(key = lambda x:(x[0],-x[1]))
        arr[0] = envelopes[0][1]
        Len = 1

        def BS(arr,low,high,target):
            while low <= high:
                mid = low + (high-low)//2
                if arr[mid] == target: return mid
                elif arr[mid] > target: high = mid - 1
                else: low = mid + 1
            return low

        for i in range(1,n):
            if arr[Len-1] < envelopes[i][1]:
                arr[Len] = envelopes[i][1]
                Len += 1
            else:
                bsIndex = BS(arr,0,Len-1,envelopes[i][1])
                arr[bsIndex] = envelopes[i][1]
        
        return Len
        