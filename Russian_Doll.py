#Space:O(n)
#Time:O(n^2)
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        envelopes = sorted(envelopes)
        dp_array = [1]*len(envelopes)
        for i in range(len(envelopes)):
            for j in range(i):
                if envelopes[i][0]>envelopes[j][0] and envelopes[i][1]>envelopes[j][1]:
                    dp_array[i]=max(dp_array[i],dp_array[j]+1)
        return max(dp_array)