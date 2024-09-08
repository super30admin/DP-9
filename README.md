# DP-9

## Problem1: Longest Increasing Subsequence (https://leetcode.com/problems/longest-increasing-subsequence/)

In this solution we are using dynammic programming with binary search to find the length of the longest increasing subsequency in the array nums. In this we will be maintaining a dp array where each element represents the smallest possible tail value of all increasing subsequences of a particular length. We are using the binary search to find the correct position in the dp array to update which will ensure the array remains sorted. 



## Problem2: Russian Doll Envelopes (https://leetcode.com/problems/russian-doll-envelopes/)

In this solution we will be sorting the envelopes by width in ascending order first and if two envelopes have the same width then we will be sorting them in descending order. We are doing this to ensure that when determining the longest increasing subsequence based on heights we are not choosing two envelopes with same width as a part of same subsequence. Then the Longest Increasing Subsequence is found using dynammic programming with binary search applied to the heights of the sorted envelopes same as above.


