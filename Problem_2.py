'''
354 Russian Doll Envelopes
https://leetcode.com/problems/russian-doll-envelopes/description/

You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

Example 1:
Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

Example 2:
Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1


Constraints:
1 <= envelopes.length <= 10^5
envelopes[i].length == 2
1 <= wi, hi <= 10^5

Solution:
1. Brute Force
Find all possible permutations of the envelopes and then prune the permutations based on the conditions in the problem.
Time: O(N!), Space: O(N)

2.  DP Tabulation (bottom-up approach)
First we sort the envelopes by width. Then once the envelopes are arranged in increasing order of their widths, we apply DP-based LIS on the heights only.
https://youtu.be/oylTlJ_TW3I?t=1947
Time: O(N log N + N^2) = O(N^2), Space: O(N)

3. Binary Search
First we sort the envelopes by width, and for equal widths, by decreasing height. Sorting heights by descending order is important before we apply binary search. Then we apply LIS logic on the heights using a binary search optimized array. We place or replace the envelope height in the correct position to track the max length.
https://youtu.be/oylTlJ_TW3I?t=3616
Time: O(N log N + N log N) = O(N log N), Space: O(N)

'''
from typing import List

def maxEnvelopes_DP(envelopes: List[List[int]]) -> int:
    if not envelopes:
        return 0
    N = len(envelopes)
    envelopes.sort(key = lambda x: x[0])
    dp = [1]*N
    max_len = 1
    for i in range(1, N):
        for j in range(i):
            if envelopes[i][1] > envelopes[j][1] and envelopes[i][0] > envelopes[j][0]:
                dp[i]  = max(dp[i], dp[j]+1)
        max_len = max(max_len, dp[i])
    return max_len

def maxEnvelopes_BS(envelopes: List[List[int]]) -> int:
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

    if not envelopes:
        return 0
    N = len(envelopes)

    # Sort envelopes ascending order of width
    # For envelopes with same width, sort by descending order of height
    envelopes.sort(key = lambda x: (x[0], -x[1]))

    result = [envelopes[0][1]]
    for i in range(N):
        if envelopes[i][1] > result[-1]:
            result.append(envelopes[i][1])
        else:
            bis = binarySearch(result, 0, len(result)-1, envelopes[i][1])
            result[bis] = envelopes[i][1]
    return len(result)

def run_maxEnvelopes():
    tests = [([[5,4],[6,4],[6,7],[2,3]], 3),
             ([[1,1],[1,1],[1,1]], 1),
    ]
    for test in tests:
        envelopes, ans = test[0], test[1]
        print(f"\nEnvelopes = {envelopes}")
        for method in ['dp', 'binary_search']:
            if method == "dp":
                max_envelopes = maxEnvelopes_DP(envelopes)
            elif method == "binary_search":
                max_envelopes = maxEnvelopes_BS(envelopes)
            print(f"Method {method}: Max no. of envelopes = {max_envelopes}")
            success = (ans == max_envelopes)
            print(f"Pass: {success}")
            if not success:
                print(f"Failed")
                return

run_maxEnvelopes()
