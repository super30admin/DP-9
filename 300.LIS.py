"""
TC: O(nlogn)
SC: O(n)
Logic:
Use modified binary search
"""
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        temp = [nums[0]]
        length = 1
        def binary_search(arr, h, target):
            l = 0
            while(l<=h):
                m = l+(h-l)//2
                if arr[m] == target:
                    return m
                elif arr[m]>target:
                    h = m-1
                else:
                    l = m+1
            return l
        for i in nums:
            if i>temp[-1]:
                temp.append(i)
                length+=1
            else:
                lb = binary_search(temp,length, i)
                temp[lb] = i
        return length