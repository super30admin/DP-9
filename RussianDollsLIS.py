'''
Solution:
1.  The main idea of DP + BS is to have an output list to maintain increasing subsequence (its length
    is required) which gets updated at each index.
    Ex  - [10  9 2 5 3 7 101 18]
    out - [10] i
    Now, if an element at current index i is greater than last element of output list => just add to output list
    else, replace the value at i in the correct position in output list using Bin. Search on output list (replace and don't insert)

2.  Ex  - [10 9 2 5 3 7 101 18]
    out - [9]   i
    Here, 9 replaces 10 in output list because, the possibility for 9 is greater to have increasing subsequence
    of greater length compared to 10.
    Think of a larger number than 10 at index 0 as 10 is just > 9 (if 10 is confusing)

3.  Ex  - [10 9 2 5 3 7 101 18]
    out - [10]          when i = 0
    out - [9]           when i = 1
    out - [2]           when i = 2
    out - [2 5]         when i = 3
    out - [2 3]         when i = 4
    out - [2 3 7]       when i = 5
    out - [2 3 7 101]   when i = 6
    out - [2 3 7 8]     when i = 7
    when i = 4, 3 replaces 5 in output list because, in future iterations, if suppose 4 appears
    in the actual array, then length of LIS will increase if output list ends with 3 instead of 5.

4.  Length of output list always gives length of max LIS, but will not give the actual LIS always.
    Example for this provided in LeetCode itself.
    Ex  - [0 8 4 12 2]
    out - [0]
    out - [0 8]
    out - [0 4]
    out - [0 4 12]
    out - [0 2 12] --> Length of output list is length of max LIS but output list is not actual LIS.

5.  Also, Binary Search is applied to place the element in correct position in output list.

Time Complexity:    O(n.logn)   |   Space Complexity:   O(n)
--- Passed all testcases successfully on leetcode.
'''


class Solution(object):
    
    def __findFirstLargestBS(self, array, target):
        
        #   Binary Search to return the index containing immediate greater value to target value

        #   initializations
        lo = 0
        hi = len(array) - 1
        
        #   until lo is strictly less than hi
        while (lo < hi):
            mid = lo + int( (hi - lo) / 2)
            
            #   update lo to mid + 1 as target value is definitely greater than mid
            if (array[mid] < target):
                lo = mid + 1
            #   otherwise move hi to mid and not mid - 1
            else:
                hi = mid
        
        #   return lo index => value imediately greater than target value       
        return lo
    
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """

        #   edge case
        if (envelopes == None or len(envelopes) == 0):
            return 0
        
        #   sort in ascending order of dimension 0 and in descending order of dimension 1
        envelopes.sort(key= lambda x: (x[0], -x[1]))
        
        #   add first element's height to the output array
        output = [envelopes[0][1]]
        
        #   for each index,
        for i in range(len(envelopes)):
            
            #   if current height is greater than last placed height => just add current height 
            if (envelopes[i][1] > output[-1]):
                output.append(envelopes[i][1])
            
            #   otherwise, find where current height can be placed using BS and place it there
            else:
                firstLargestIndex = self.__findFirstLargestBS(output, envelopes[i][1])
                output[firstLargestIndex] = envelopes[i][1]
        
        #   return the length of output array        
        return len(output)