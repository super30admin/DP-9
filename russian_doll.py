#Time -> nlogn
#Space -> O(n)

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        env=sorted(envelopes,key=lambda x:(x[0],-x[1]))
        LIS = []
        size = 0
        for (w, h) in env:
            if not LIS or h > LIS[-1]:
                LIS.append(h)
                size += 1
            else:
                l, r = 0, size
                while l < r:
                    m = l + (r - l) // 2
                    if LIS[m] < h:
                        l = m + 1
                    else:
                        r = m
                LIS[l] = h
        return size

        