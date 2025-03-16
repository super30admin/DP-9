class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # T: O(n log n), S: O(n)
        sub = []

        for num in nums:
            idx = bisect_left(sub, num)  # Find position to replace or extend
            if idx == len(sub):
                sub.append(num)  # Append if it's larger than all elements
            else:
                sub[idx] = num  # Replace to maintain the smallest possible LIS

        return len(sub)  # Length of LIS
