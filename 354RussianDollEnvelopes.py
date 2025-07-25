"""
TC: O(nlogn)
SC: O(n)
Logic:
Sort the array in increasing order of width and decreasing orde of height
Then do LIS on height
Use modified binary search for LIS. You can use bisect_left instead of implementing binary search to find
the insertion index of an element.
"""
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key = lambda x:(x[0],-x[1]))
        temp = []
        temp.append(envelopes[0])
        length = 1
        def binary_search(arr, h, target):
            l = 0
            while(l<=h):
                m = l+(h-l)//2
                if arr[m][1] == target:
                    return m
                elif arr[m][1]<target:
                    l=m+1
                else:
                    h = m-1
            return l

        for env in envelopes:
            if temp[-1][1]<env[1]:
                temp.append(env)
                length+=1
            else:
                bs_idx = binary_search(temp, length, env[1])
                temp[bs_idx] = env
        return length