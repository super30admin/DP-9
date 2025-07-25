class Solution:
    def getSmallestGreaterElement(self, l, r, nums, newNum):
       
        while l < r:
            mid = l + (r - l)//2
            if newNum <= nums[mid]:
                r = mid
            else:
                l = mid + 1
        return r

    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0],-x[1]))
        #ea=> effective array
        ea = []

        for w, h in envelopes:
            if not ea or ea[-1] < h:
                ea.append(h)
            else:
                idx = self.getSmallestGreaterElement(0, len(ea) - 1, ea, h)
                ea[idx] = h
        return len(ea)