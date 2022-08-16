class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # approach linear search with DP
        # maintain a DP array such that, at each index `i` check all the numbers 
        # towards the left of `i`th index over all k elements thus far 
        # and see what's the longest increasing subsequence 
        # we can form, and take a maximum of such numbers and add 1 to it for element at the current index
        # we can only take the numbers from dp array if nums[i-k] is less that nums[i]
        # TC: O(n^2)
        # SC: O(n)
        
        dp = [1] * len(nums)
        max_dp = 1
        i = 1
        while i < len(nums):
            res = 0
            for j in range(0,i):
                if nums[j] < nums[i]:
                    res = max(res, dp[j])
            dp[i] += res # this is same as 1+res, as at each index i we have default value of 1
            max_dp = max(max_dp, dp[i])
            i += 1

        return max_dp


from bisect import bisect_left
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # approach Binary search using python bisect_left
        # TC O(n log n) - as we run binary search n times
        # SC O(n) - max len of sub array
        # We create a sub array starting with number at 0th index
        # At each step after that, check can we insert ith element in the subarray
        # use python bisect.bisect_left() to find index to the left of which we can insert the
        # number at index i. If bisect output is eq to len of sub, means current element is largest
        # we have seen so far. So we will append it to sub array.
        # else we replace element in the sub array with current element.
        # at the end we return len of sub array. And advantage of this approach is we can also
        # produce the sub array if required as we are already creating it.
        
        
        sub = [nums[0]]
        
        for i in range(1, len(nums)):
            j = bisect_left(sub, nums[i])
            
            if j == len(sub):
                sub.append(nums[i])
            else:
                sub[j] = nums[i]
        # print(sub)
        return len(sub)
        