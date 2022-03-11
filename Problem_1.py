# Time: O(nlogn), logn for searching the position for the element's and there are n steps.
# Space: O(n)
# runs on leetcode : YES
# any problems faced : NO
#bisect is python library to maintain sorted order of the array in python

from bisect import bisect_left
class Solution:
	def lengthOfLIS(self, nums):
		dp = []
		for elem in nums:
			idx = bisect_left(dp, elem)
			if idx == len(dp):
				dp.append(elem)
			else:
				dp[idx] = elem
		return len(dp)