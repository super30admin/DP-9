#Approach : using Binary Search
# Time Complexity : O(nlogn)
# Space Complexity : O(n)
from typing import List
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        envelopes.sort(key=lambda a: (a[0], -a[1]))
        
        le = 1
        arr = [0]*n
        arr[0] = envelopes[0][1]
        for i in range(1, len(envelopes)):
            if arr[le-1] < envelopes[i][1]:
                arr[le] = envelopes[i][1]
                le+=1
            else:
                bsIdx = self.binarySearch(arr, 0, le-1, envelopes[i][1])
                arr[bsIdx] = envelopes[i][1]

        return le
    
    def binarySearch(self, arr, low, high, target):
        while(low<=high):
            mid = int(low +(high-low)/2)
            if arr[mid] == target:
                return mid
            elif (arr[mid] < target):
                low = mid+1
            else:
                high = mid-1
        
        return low