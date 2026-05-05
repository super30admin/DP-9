# problem 2 

# https://leetcode.com/problems/russian-doll-envelopes/


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0],-x[1]))
        result_arr = []
        for w,h in envelopes:
            left = 0 
            right = len(result_arr)-1
            while left<=right:
                mid=(left+right)>>1
                if result_arr[mid]>=h:
                    right=mid-1
                else:
                    left=mid+1 
            idx = left 
            if idx == len(result_arr):
                result_arr.append(h)
            else:
                result_arr[idx] = h
        return len(result_arr)