class Solution:
    # binary search approach
    # TC: O(nlogn)
    # SC : O(n)
    def binarySearch(self,res : List[int],low:int,high:int,target:int)->int:
        while low <= high:
            mid = low + (high-low)//2
            if res[mid] == target:
                return mid
            elif target> res[mid]:
                low = mid +1
            else:
                high = mid - 1
        return low
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if envelopes is None:
            return 0
        n = len(envelopes)
        envelopes.sort(key = lambda x:(x[0],-x[1]))
        res = [0]*n
        res[0] = envelopes[0][1] # fill it with height of 1st envelope after sorting
        lenv = 1
        for i in range(1,n):
            if envelopes[i][1] > res[lenv-1]:
                res[lenv] = envelopes[i][1]
                lenv += 1
            else:
                bsindex = self.binarySearch(res,0,lenv-1,envelopes[i][1])
                res[bsindex] = envelopes[i][1]
        return lenv
