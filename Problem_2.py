"""
Time Complexity : O(nlogn) for optimal solution and O(nlogn+ n^2) for DP solution
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
This question is similar to the longest increasing subsequence problem. The only difference, we need to sort the envelopes array
in increasing order of first index and decreasing order of last index. After that, do exactly like the first question.

"""


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        length = len(envelopes)
        effBSArr = []
        effBSArr.append(envelopes[0][1])
        for i in range(1, length):
            if envelopes[i][1] > effBSArr[-1]:
                effBSArr.append(envelopes[i][1])
            else:
                position = self.binarySearch(
                    effBSArr, 0, len(effBSArr)-1, envelopes[i][1])
                effBSArr[position] = envelopes[i][1]
        return len(effBSArr)

    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low+(high-low)//2
            if arr[mid] == target:
                return mid
            if arr[mid] > target:
                high = mid-1
            else:
                low = mid+1
        return low

# class Solution:
#     def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
#         if not envelopes:
#             return 0
#         envelopes.sort()
#         max_=1
#         length=len(envelopes)
#         dp=[1 for _ in range(length)]
#         for i in range(1,length):
#             for j in range(0,i):
#                 if envelopes[i][1]>envelopes[j][1] and envelopes[i][0]>envelopes[j][0]:
#                     dp[i]=max(dp[i],dp[j]+1)
#                     max_=max(max_,dp[i])
#         return max_
