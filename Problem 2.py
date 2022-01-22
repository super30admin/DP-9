# Time: O(n*n)
# Space: O(n)
class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        def compare(a,b):
            return a[0] - b[0]
        envelopes = sorted(envelopes, cmp=compare)
        ans = [1] * len(envelopes)
        ret = 1
        for i in range(1, len(envelopes)):
            for j in range(0, i):
                if envelopes[j][0] < envelopes[i][0] and envelopes[j][1] < envelopes[i][1]:
                    ans[i] = max(ans[i], ans[j]+1)
            ret = max(ret, ans[i])
        return ret# Time: O(nlogn)
# Space: O(n)
class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        def compare(a,b):
            if a[0] == b[0]:
                return b[1] - a[1]
            return a[0] - b[0]
        envelopes = sorted(envelopes, cmp=compare)
        seq = []
        seq.append(envelopes[0][1])
        for i in range(1, len(envelopes)):
            if envelopes[i][1] > seq[-1]:
                seq.append(envelopes[i][1])
            else:
                sorted_index = self.binary_search(seq, envelopes[i][1])
                seq[sorted_index] = envelopes[i][1]
        return len(seq)
    def binary_search(self, seq, val):
        left = 0
        right = len(seq) - 1
        while left <= right:
            middle = left + (right-left)/2
            if seq[middle] == val:
                return middle
            elif seq[middle] > val:
                right = middle-1
            else:
                left = middle + 1
        return left
