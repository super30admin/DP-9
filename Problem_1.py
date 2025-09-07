'''
300 Longest Increasing Subsequence
https://leetcode.com/problems/longest-increasing-subsequence/description/

Given an integer array nums, return the length of the longest strictly increasing subsequence.
(A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements)


Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:
1 <= nums.length <= 2500
-10^4 <= nums[i] <= 10^4

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?

Solution:
1. Brute Force
Generate all possible sequences and prune all sequences which are not increasing subsequences
Time: O(2^N), Space: O(N)

2. Tabulation (bottom-up approach)
We try to build the longest increasing sequence ending at each number.
For every reference number in nums, we look back and check which smaller numbers can be added before the ref num to form an increasing subsequence.
We keep updating the best result as we go through the array.
Length of LIS: https://youtu.be/sK8MUV3ruzg?t=3097
Print the LIS: https://youtu.be/sK8MUV3ruzg?t=4026
Print the LIS (space optimimized): https://youtu.be/sK8MUV3ruzg?t=4461
Time: O(N^2), Space: O(N)

3. Binary Search
With B/S, we are not trying to find the LIS. Instead we are trying to find the length of the LIS. We show the working of the B/S approach using an example. Consider nums = [0,3,2,4,5,1]. The B/S intermediate results
are
i=0, num=0, res = [0]    (since res is empty, append num to res)
i=1, num=3, res = [0, 3] (since num > res[-1], append num to res)
i=2, num=2, res = [0, 2] (num < res[-1], repl num's supremum in rest by num)
i=3, num=4, res = [0,2,4] (since num > res[-1], append num to res)
i=4, num=5, res = [0,2,4,5] (since num > res[-1], append num to res)
i=5, num=1, res = [0,1,4,5] (num < res[-1], repl num's supremum in rest by num)

Note that the true LIS = [0,2,4,5] which is not the same as res[].
However, len(LIS) is the same as len(res).

Steps: For every element in the original array nums,
a) if result is empty or num > result[-1], append to result
b) if num < result[-1], find the supremum in the result and REPLACE the SUPREMUM by the NUM.
c) the length of the result is the length of the LIS

https://youtu.be/oylTlJ_TW3I?t=434
https://youtu.be/on2hvxBXJH4?t=151
Time: O(N log N), Space: O(N)

'''
from typing import List

def lengthOfLIS_DP(nums: List[int]) -> int:
    ''' Time: O(N^2), Space: O(N) '''
    if not nums:
        return 0
    N = len(nums)
    dp = [1]*N
    max_len = 1
    for i in range(1, N):
        for j in range(i):
             if nums[i] > nums[j]:
                dp[i]  = max(dp[i], dp[j]+1)
        max_len = max(max_len, dp[i])
    return max_len

def lengthOfLIS_BS(nums: List[int]) -> int:
    ''' Time: O(N log N), Space: O(N) '''

    def binarySearch(arr, low, high, tgt):
        ''' binary search returns the index of supremum of the tgt '''
        if not arr:
            return -1
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == tgt:
                return mid
            if tgt > arr[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return low

    if not nums:
        return 0
    N = len(nums)
    result = [nums[0]]
    for i in range(1,N):
        if nums[i] > result[-1]:
            result.append(nums[i])
        else:
            bis = binarySearch(result, 0, len(result)-1, nums[i])
            result[bis] = nums[i]

    return len(result)


def run_lengthOfLIS():
    tests = [([10,9,2,5,3,7,101,18], 4),
             ([10,9,2,5,3,7,1,101,18], 4), # at 101, max(dp[i],dp[j]+1) tested
             ([10,9,2,5,3,7,101,18,19,1], 5), # binary search puts 1 in the front
             ([0,3,2,4,1], 3),  # binary search puts 1 in the front
    ]
    for test in tests:
        nums, ans = test[0], test[1]
        print(f"\nnums = {nums}")
        for method in ['dp', 'binary_search']:
            if method == "dp":
                max_len = lengthOfLIS_DP(nums)
            elif method == "binary_search":
                max_len = lengthOfLIS_BS(nums)
            print(f"Method {method}: Length of LIS = {max_len}")
            success = (ans == max_len)
            print(f"Pass: {success}")
            if not success:
                print(f"Failed")
                return

run_lengthOfLIS()
