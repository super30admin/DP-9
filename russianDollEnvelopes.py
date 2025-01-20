# // Time Complexity :O(nlogn) for sorting and binary search
# // Space Complexity :O(n) for arr
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Initialized length as 0 


# // Your code here along with comments explaining your approach
# LIS 213 ms
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        sortx = sorted(envelopes, key = lambda x: (x[0],-(x[1])))
        n = len(envelopes)
        length = 1                  # initialize on 1
        arr = [0] * n               # lis on heihght
        arr[0] = sortx[0][1]

        # if current element is greater than top element of arr, add to it
        # if uncertain dimensions find smallest using binary search
        for i in range(1,n):
            if sortx[i][1] > arr[length-1]:
                arr[length] = sortx[i][1]           # set index
                length += 1
            else:
                bsIndex = self.binarySearch(arr,0,length-1,sortx[i][1])
                arr[bsIndex] = sortx[i][1]          # replace index

        return length

    def binarySearch(self, arr,low, high,target):
        while low <= high:
            mid = low + (high-low)//2

            if arr[mid] == target:
                return mid
            if arr[mid] > target :
                high = mid - 1
            else:
                low = mid + 1
        return low