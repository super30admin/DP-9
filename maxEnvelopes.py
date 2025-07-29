# TimeComplexity:O(nlogn)
# SpaceComplexity:O(n)
# Approach:
# BF and dp are similar to LIS
# optimal would be either sort based on heights/widths and if equal envelopes.sort(key=lambda x:(x[0], -1*x[1])) upadte our effective LIS with BS
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x:(x[0], -1*x[1]))
        #lis on height [1]
        def bs(nums, i):
            l, h = 0, len(nums) - 1
            ans = len(nums)  # Default index if all elements < i

            while l <= h:
                mid = (l + h) // 2
                if nums[mid] >= i:
                    ans = mid  # potential answer, but look left for smaller ≥ i
                    h = mid - 1
                else:
                    l = mid + 1

            return ans
        arr=[envelopes[0][1]]
        for ele in envelopes:
            if ele[1]>arr[-1]:
                arr.append(ele[1])
            else:
                bsidx=bs(arr,ele[1])
                arr[bsidx]=ele[1]

        return len(arr)
            
#-------------
# DP gives TLE
#-------------
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort()
        dp=[1 for _ in range(len(envelopes))]
        mx=float('-inf')
        for i in range(len(envelopes)):

            for j in range(i):
                
                if envelopes[j][0]<envelopes[i][0] and envelopes[j][1]<envelopes[i][1]:
                    dp[i]=max(dp[j]+1,dp[i])
                
            mx=max(mx,dp[i])
        print(dp)
        return mx
