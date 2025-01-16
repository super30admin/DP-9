# Approach:
# We can solve this problem using dynamic programming (DP) with a time complexity of O(n^2).
# However, the follow-up asks for a more optimized solution that runs in O(n log n).
# We can achieve this by using binary search and a dynamic list.
# The idea is to maintain a list that stores the smallest possible tail values for subsequences of various lengths.
# For each number in the input, we use binary search to find the position where the current number should be placed,
# and then update the corresponding position in the list.
# Time Complexity: O(n log n), where n is the length of the input array. We perform binary search for each element.
# Space Complexity: O(n), for the list that stores the smallest possible tail values for subsequences of various lengths.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # Initialize an empty list to store the smallest tail values of subsequences
        tails = []
        
        # Iterate through each number in the input array
        for num in nums:
            # Find the index where the current number should be placed using binary search
            pos = bisect.bisect_left(tails, num)
            
            # If the number is larger than any existing element in the list, append it
            if pos == len(tails):
                tails.append(num)
            else:
                # Otherwise, replace the element at the found position with the current number
                tails[pos] = num
        
        # The length of the 'tails' list represents the length of the longest increasing subsequence
        return len(tails)
