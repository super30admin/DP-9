'''
Time Complexity --> O(nlogn)
Space omplexity --> O(n)
Binary Search Approach can be used here
'''
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        #dp=[1 for x in range(len(envelopes))]
        envelopes = sorted(envelopes, key=lambda x:x[1], reverse=True)
        envelopes = sorted(envelopes, key=lambda x:x[0])
        #print(envelopes)
        
        #print(nums)
        # for i in range(1, len(envelopes)):
        #     for j in range(0, i):
        #         if nums[j]<nums[i] and envelopes[i][0]>envelopes[j][0]:
        #             dp[i] = max(1+dp[j], dp[i])
        #             max_val = max(max_val, dp[i])
        # return max_val
        def BinarySearch(l, r, dp, target):
            #print(dp)
            while l<=r:
                m = (l+r)//2
                if dp[m] == target:
                    return m
                elif dp[m] < target:
                    l = m+1
                else:
                    r = m-1
            #print(l)
            return l
        
        print(envelopes)
        dp = [envelopes[0][1]]
        l = len(dp)-1
        for i in range(1, len(envelopes)):
            if envelopes[i][1] <= dp[l]:
                index = BinarySearch(0, l, dp, envelopes[i][1])
                dp[index] = envelopes[i][1]

            else:
                dp.append(envelopes[i][1])
                l+=1
        return(len(dp))





                