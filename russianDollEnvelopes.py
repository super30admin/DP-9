# Time Complexity : O(nlgn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        #need to sort envelopes. then can do similar to LongestIncreasingSubSequence
        envelopes.sort(key = lambda x: (x[0], -x[1]))
        seq = []
        for i in envelopes:
            if not seq or (seq[-1][0] < i[0] and seq[-1][1] < i[1]):
                seq.append(i)
            else:
                index = self.bSearch(seq, i[1], 0, len(seq)-1)
                seq[index] = i
                
        return len(seq)
    
    def bSearch(self, arr, target, left, right):
        while left <= right:
            mid = left + (right-left)//2
            if arr[mid][1] == target:
                return mid
            elif arr[mid][1] < target:
                left = mid + 1
            else:
                high = mid - 1
        
        return left