"""
Sub sequence: can skip values in between. Substring should be continuous.
It cannot be solved with the 2 for loops. For example, [1, 10, 2,3,4,5]. If solved with 2 for loops.
The longest subsequence starting with 1 would be [1,10], but actually it is [1,2,3,4,5].
Approach 1: exhaustive build all the subsequences starting with 1 then with 10 and check the length.
The exhaustive approach includes choose and not choose approach. while building the tree, we can find the same sub-problems
such as [2.....18] with [9] and [2.....18] with [10]. If I know the length of subsequence for [2.....18] I could use it
to solve both the problems.

Approach2: using tabulation, Check comments. This approach could help us find the actual value of the subsequence.
TC: O(n^2) and SC: O(n)
Approach2: binary search: maintain an effective array why effective because this gives the length of array but not the
actual subsequence.
Add the first element into the array if the incoming element is greater than the last element of the effective array, add it
to the effective array else replace it with the next greatest element.
TC: O(n log n)
why replace it? this can handle the edge case [1, 10, 2,3,4,5]. discussed above.
"""
from typing import List


class Solution:
    def binarySearch(self, lo, hi, target, arr):
        while (lo <= hi):
            mid = lo + (hi - lo) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                hi = mid - 1

            elif arr[mid] < target:
                lo = mid + 1
        # lo return the next greater number
        # hi return the smaller number
        return lo

    def lengthOfLIS(self, nums: List[int]) -> int:
        arr = []
        arr.append(nums[0])
        print(arr)
        for idx in range(1, len(nums)):
            if nums[idx] > arr[-1]:
                arr.append(nums[idx])
            else:
                # search is done in the effective array
                new_idx = self.binarySearch(0, len(arr) - 1, nums[idx], arr)
                arr[new_idx] = nums[idx]

        return len(arr)



class Solution_dp:
    def lengthOfLIS(self, nums: List[int]) -> int:
        ans = 1
        # at each index the length of max subsequence is 1
        dp = [1 for _ in range(len(nums))]

        for i in range(1, len(nums)):
            # at a given index we explore all the possibilities before that index
            for j in range(0, i):
                # check if incoming can be part of solution
                # i is the incoming number
                # j is already solved
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
                    ans = max(ans, dp[i])
            # after j reach i: the element at dp[i] is the sol till that index
            # To keep track of the actual subsequence if the incoming character can be part of the subsequence add it.
            # Else do not.

        return ans


class Solution_dp_to_get_actual_sequence:
    def lengthOfLIS(self, nums: List[int]) -> int:
        ans = 1
        # at each index the length of max subsequence is 1
        dp = [1 for _ in range(len(nums))]
        path = [[nums[i]] for i in range(len(nums))]
        for i in range(1, len(nums)):
            # at a given index we explore all the possibilities before that index
            for j in range(0, i):
                # check if incoming can be part of solution
                # i is the incoming number
                # j is already solved
                if nums[i] > nums[j]:

                    if dp[i] < dp[j] + 1:
                        dp[i] = dp[j] + 1
                        path[i] = path[j][:]
                        path[i].append(nums[i])

                    ans = max(ans, dp[i])
            # after j reach i: the element at dp[i] is the sol till that index
        print(path)

        return ans


class Solution_brute_force:
    def helper(self, pivot, nums, path):
        # base case
        self.ans = max(self.ans, len(path))

        # logic
        # since using for loop based recusion not choose case
        # will be considered automatically
        for idx in range(pivot, len(nums)):
            # comapre with the last added number
            # what if path is empty
            if not path or nums[idx] > path[-1]:
                path.append(nums[idx])
                self.helper(idx + 1, nums, path)
                path.pop()

    def lengthOfLIS(self, nums: List[int]) -> int:
        self.ans = 0
        self.helper(0, nums, [])
        return self.ans