#Time Complexity : O(NlogN)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda sl: (sl[0],-sl[1]))
        li = []
        li.append(envelopes[0][1])
        for i in range(1,len(envelopes)):
            if envelopes[i][1] > li[-1]:
                li.append(envelopes[i][1])
            else:
                index = self.binarysearch(0,len(li)-1,envelopes[i][1],li)
                li[index] = envelopes[i][1]
        return len(li)
                
    def binarysearch(self,low,high,target,li):
        while low <= high:
            mid = (low + high) // 2
            if li[mid] == target:
                return mid
            elif li[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
                
        return low