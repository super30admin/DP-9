# Binary Search Approach
# Time Complexity: O(n log n)
# Space Complexity: O(n)
class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        # Edge Case
        if not envelopes:
            return 0

        # Sort the input array by index 0 in crereasing order and index 1 in decreasing order
        # Envelopes that are equal in index 0 can never be in the same increasing subsequence
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        # Initialize aux array to hold the longest increasing subsequence so far
        aux = [envelopes[0][1]]

        for i in range(1, len(envelopes)):
            if envelopes[i][1] > aux[-1]:
                aux.append(envelopes[i][1])
            else:
                idx = bisect.bisect_left(aux, envelopes[i][1], 0, len(aux)-1)
                aux[idx] = envelopes[i][1]
        return len(aux)
