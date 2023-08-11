class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        # The code uses binary search to efficiently find the LIS.
        # Time Complexity: O(n log n), where n is the number of envelopes, due to the binary search.
        # Space Complexity: O(n), where n is the number of envelopes, for the lis list.

        if not envelopes:
            return 0

        # Define a custom sort function to sort envelopes by width in ascending order
        # and height in descending order
        def custom_sort(envelope):
            return (envelope[0], -envelope[1])

        # Sort the envelopes based on the custom sort function
        envelopes.sort(key=custom_sort)

        # Define a binary search function to find the position to insert a target in a sorted array
        def binary_search(nums, target):
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = left + (right - left) // 2
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return left

        lis = []  # List to store the height values of envelopes in the LIS

        # Iterate through each envelope
        for _, h in envelopes:
            if not lis or h > lis[-1]:
                # If the current height is greater than the last height in lis, append it
                lis.append(h)
            else:
                # Otherwise, find the position to insert the current height using binary search
                idx = binary_search(lis, h)
                lis[idx] = h  # Update the value at the found position

        return len(lis)
