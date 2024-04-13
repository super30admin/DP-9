'''
Time Complexity - O(nlogn) for sorting and then using binary search. O(n^2) for using DP. 
Space Complexity - O(n) for both DP and Binary Search.

Works on Leetcode.
'''
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        #sort according to widths, if the width is same, sort by descending heights
        envelopes = sorted(envelopes, key = lambda x:(x[0], -x[1]))

        #DP #TLE
        # lis = [1] * n
        # for i in range(1, n):
        #     for j in range(0,i):
        #         if envelopes[i][1] > envelopes[j][1]:
        #             lis[i] = max(lis[i], 1+lis[j])
        # return max(lis)


        #create arr and insert first height and make pointer point to last + 1
        arr = [envelopes[0][1]]
        le = 1
        for i in range(1,n):
            #if current height greater than last in arr then append to arr and move ptr by 1
            if envelopes[i][1] > arr[le-1]:
                arr.append(envelopes[i][1])
                le+=1
            #else find the next greater height in arr using Binary Search and replace that height
            else:
                bsIndex = self.binarySearch(arr, envelopes[i][1], 0, le-1)
                arr[bsIndex] = envelopes[i][1]
        return le
    
    def binarySearch(self, arr, target, low, high):
        while low<=high:
            mid = low + (high-low)//2
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low

        