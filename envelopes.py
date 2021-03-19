class Solution:
    
    """
    Description: envelopes are 2D array of integers where width and height of each is presented. One can fit under the other only if both are greather, find max number of envelopes one can fit
    
    Time Complexity: O(n log n)
    Space Complexity: O(n)
    
    Approach: Use of Binary Search (from LIS algorithm)
    1. First sort the array using first index value in ascending order and last index value in descending order 
       - Done to ensure when first index matches, we have a break in finding LIS coming from sequence of second index values
    2. Use LIS with binary search to identify the maximum length of subsequence which should give us the max number of envelopes can be fitted 
    """
    
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        if envelopes == None: return 0

        envelopes = sorted(envelopes, key = lambda x: (x[0], -x[1]))
        arr = [0]*len(envelopes); arr[0] = envelopes[0][1]
        length = 1

        for i in range(1, len(envelopes)):
            if envelopes[i][1] > arr[length - 1]:
                arr[length] = envelopes[i][1]
                length += 1
            else:
                idx = self.binSearch(arr, envelopes[i][1], 0, length)
                arr[idx] = envelopes[i][1]
        
        return length
                    
    def binSearch(self, arr, target, low, high):
        
        while low <= high:
            mid = low + int((high - low)/2)
            if arr[mid] == target: return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
                
        return low
