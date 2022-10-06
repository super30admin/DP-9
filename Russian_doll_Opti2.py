# Time complexity : O(n*log n)
# Space complexity : O(n)
# Leetcode : Time limit exceeded

# using the bisect_left function which is present in the python library
# behind the scenes, it uses the binary search to look for the index to insert an element
# bisect_left would look for a position just before the element if present or leftmost to that element

from bisect import bisect_left
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
      
        # sort the array asc on 1st value of list and then desc on 2nd value of list
        envelopes.sort(key = lambda x: [x[0],-x[1]])
        n = len(envelopes)
        arr = []
        arr.append(envelopes[0][1])
        
        for i in range(1,n):
            for j in range(i):
               # find the index using bisect_left for insertion
                idx = bisect_left(arr, envelopes[i][1])
                
                # if we have a bigger value than the last element in the list, just insert at the end
                if arr[-1] < envelopes[i][1]:
                    arr.append(envelopes[i][1])
                else:
                    # otherwise insert at the index we found
                    arr[idx] = envelopes[i][1]
        
        return len(arr)
