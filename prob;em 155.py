#  https://leetcode.com/problems/russian-doll-envelopes/

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key = lambda x : (x[0], -x[1]))
        n = len(envelopes)
        self.arr = [0] * (n)
        self.arr[0] = envelopes[0][1]
        idx = 1
        for i in range(1,n):
            if envelopes[i][1] > self.arr[idx - 1]:
                self.arr[idx] = envelopes[i][1]
                idx += 1
            else:
                bstidx = self.binarysearch(self.arr,0,idx,envelopes[i][1])
                self.arr[bstidx] = envelopes[i][1]
        return idx
    
    def binarysearch(self,arr,low,high,target):
        while low<=high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low

# TC: O(n logn) for sorting and then doing BS for n entries
# SC: O(n)