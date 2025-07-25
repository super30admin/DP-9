
''' 
Time Complexity: O(nlogn) 
Space Complexity: O(n)  

Approach: 
1. Sort the envelopes by width in ascending order. If two envelopes have the same width, sort them by height in descending order.
2. Initialize a list sub to store the heights of the envelopes that can be nested.
3. Iterate through the sorted envelopes and for each envelope, if its height is greater than the last height in sub, append it to sub.
4. If its height is less than or equal to the last height in sub, use binary search to find the index of the first height in sub that is greater than or equal to the current height. Replace the height at this index with the current height.
5. Return the length of sub.

'''
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        sortedEnvelopes = sorted(envelopes, key=lambda x:[x[0], -x[1]])
        
        sub = [sortedEnvelopes[0][1]]
        for i in range(1, len(sortedEnvelopes)):
            if sortedEnvelopes[i][1]>sub[-1]:
                sub.append(sortedEnvelopes[i][1])
            else:
                indexToBeReplaced = bisect_left(sub, sortedEnvelopes[i][1])
                sub[indexToBeReplaced] = sortedEnvelopes[i][1]
        
        return len(sub)
    
'''
Time Complexity: O(nlogn) 
Space Complexity: O(n)  

Approach: 
1. Sort the envelopes by height in ascending order. If two envelopes have the same height, sort them by width in descending order.
2. Initialize a list sub to store the widths of the envelopes that can be nested.
3. Iterate through the sorted envelopes and for each envelope, if its width is greater than the last width in sub, append it to sub.
4. If its width is less than or equal to the last width in sub, use binary search to find the index of the first width in sub that is greater than or equal to the current width. Replace the width at this index with the current width.
5. Return the length of sub.
'''    

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        sortedEnvelopes = sorted(envelopes, key=lambda x:[x[1], -x[0]])
        
        sub = [sortedEnvelopes[0][0]]
        for i in range(1, len(sortedEnvelopes)):
            if sortedEnvelopes[i][0]>sub[-1]:
                sub.append(sortedEnvelopes[i][0])
            else:
                indexToBeReplaced = bisect_left(sub, sortedEnvelopes[i][0])
                sub[indexToBeReplaced] = sortedEnvelopes[i][0]
        
        return len(sub)






        






        