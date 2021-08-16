class Solution:
    # Approach 1 : DP --> Time limit exceeds
    """
    TC: O(n log n)
    SC: O(n)
    """
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        dp = [1] * n
        result = 1
        envelopes.sort(key = lambda x: x[1])
        for i in range(1, n):
            for j in range(i):
                if envelopes[i][0] > envelopes[j][0] and envelopes[i][1] > envelopes[j][1]:
                    dp[i] = max(dp[i], dp[j]+1)
                    result = max(result, dp[i])
        return result
    
    # Approach 2: Binary search + effetive subsequence list
    """
    Make sure to sort the array such that the weights are arranged in increasing order. For same widths, the heights should be arranged in decreasing order
        a) This will ensure that we have a higher probablity of adding more envelops
    TC:
    SC:
    """
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        envelopes.sort(key = lambda x: (x[0], -x[1]))
        effective = [envelopes[0]]
        for i in range(1,n):
            if envelopes[i][0] > effective[-1][0] and envelopes[i][1] > effective[-1][1]:
                effective.append(envelopes[i])
            else:
                replacable_index = self.binary_search(effective, 0, len(effective)-1, envelopes[i][1])
                if replacable_index < len(effective):
                    effective[replacable_index] = envelopes[i]
                else:
                    effective.append(envelopes[i])
        return len(effective)
    
    def binary_search(self, nums, start, end, target):
        while start <= end:
            mid = start + (end - start)//2
            if nums[mid][1] == target: return mid
            elif nums[mid][1] > target:
                end = mid - 1
            else: start = mid + 1
        return start