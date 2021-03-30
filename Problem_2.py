#Time Complexity: O(nlogn)
# Space Complexity:  O(n)

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes or len(envelopes) == 0:
            return 0
        
        envelopes.sort(key = lambda x:(x[0], -x[1])) 
        effBSArray = []
        len_point = 1 # len_point put on effBSArray
        effBSArray.append(envelopes[0][1])
        
        for i in range(1, len(envelopes)):
            if envelopes[i][1] > effBSArray[-1]:
                effBSArray.append(envelopes[i][1])
                len_point += 1
            else:
                bsIdx = self.binarySearch(effBSArray, 0, len(effBSArray)- 1, envelopes[i][1])
                effBSArray[bsIdx] = envelopes[i][1]
                
        return len_point
    
    def binarySearch(self, effBSArray, low, high, target): # normal and closed Binary search
        while low <= high:
            mid = low + (high - low) // 2
            if effBSArray[mid] == target:
                return mid
            if effBSArray[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low # low is always ending at the right position 
