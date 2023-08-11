class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:

        # The code implements the "Longest Increasing Subsequence" problem using a binary search-based approach.
        # Time complexity - O(n log n) due to the binary search operation
        # Space complexity - O(n) due to the arr array
        if nums is None or len(nums) == 0:
            return 0

        n = len(nums)
        # Initialize an array to store the longest increasing subsequence ending at each index
        arr = [0] * n
        arr[0] = nums[0]
        longest = 1  # Initialize the length of the longest increasing subsequence

        # Binary search function to find the insertion point of a value in the sorted array
        def binarySearch(arr, low, high, target):
            while low <= high:
                mid = low + (high - low) // 2
                if arr[mid] == target:
                    return mid
                elif arr[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return low

        for i in range(1, n):
            if nums[i] <= arr[longest - 1]:
                # Find the insertion point
                bsIdx = binarySearch(arr, 0, longest - 1, nums[i])
                # Insert the value at the appropriate position
                arr[bsIdx] = nums[i]
            else:
                # Update the last element of the longest subsequence
                arr[longest] = nums[i]
                longest += 1

        return longest
