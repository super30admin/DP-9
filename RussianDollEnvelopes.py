# Time Complexity : O(nlogn), where n is the number of envelopes
# Space Complexity : O(n)
from bisect import bisect_left

class Solution:
    def maxEnvelopes(self, envelopes):
        if not envelopes or len(envelopes[0]) != 2:
            return 0
        
        # Sort the envelopes first by width in ascending order.
        # If the width is the same, sort by height in descending order.
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        
        # Extract the heights and find the length of the longest increasing
        # subsequence
        heights = [envelope[1] for envelope in envelopes]
        
        return self.lengthOfLIS(heights)
    
    def lengthOfLIS(self, nums):
        dp = []
        for num in nums:
            i = bisect_left(dp, num)
            if i < len(dp):
                dp[i] = num
            else:
                dp.append(num)
        return len(dp)

# Examples

# Example 1
envelopes = [[5, 4], [6, 4], [6, 7], [2, 3]]
sol = Solution()
print(sol.maxEnvelopes(envelopes))  # Output: 3

# Example 2
envelopes = [[1, 1], [1, 1], [1, 1]]
sol = Solution()
print(sol.maxEnvelopes(envelopes))  # Output: 1

# Example 3
envelopes = [[4, 5], [4, 6], [6, 7], [2, 3], [1, 1]]
sol = Solution()
print(sol.maxEnvelopes(envelopes))  # Output: 4