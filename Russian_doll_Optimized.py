# Time complexity : O(n*logn)
# Space complexity : O(n)
# Leetcode : Time limit exceeded

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
      
        # sort the envelopes array asc on the first values and desc on the second values
        envelopes.sort(key = lambda x: [x[0],-x[1]])
        n = len(envelopes)
        
        # create an empty array and add the first element of the list
        arr = []
        arr.append(envelopes[0][1])
        
        # traverse all the possibilities
        for i in range(1,n):
            for j in range(i):
                # if the current element is greater than the last element in the array list
                if arr[-1] < envelopes[i][1]:
                    # simply add the current element at the end of the array list
                    arr.append(envelopes[i][1])
                else:
                    # find the index in the array where this element could fit using Binary search
                    idx = self.binarySearch(arr, 0, len(arr) - 1, envelopes[i][1])
                    
                    # replace the element at the index found in the above line
                    arr[idx] = envelopes[i][1]
        
        # return the len of the array as that is the longest subsequence we can find
        return len(arr)
    
    # binary search function to find the index of the element to be inserted at
    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                return mid
            if arr[mid] < target:
                low = mid + 1
            elif arr[mid] > target:
                high = mid - 1
        return low
