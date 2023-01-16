'''
Time Complexity --> O(nlogn)
Space ompelxity --> O(n)
We can make use of binary Search approach
'''
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:

        # max_val = 1
        # dp = [1 for x in range(len(nums))]
        # for i in range(1, len(nums)):
        #     for j in range(0, i):
        #         if nums[i]>nums[j]:
        #             dp[i] = max(dp[i], 1+dp[j])
        #             max_val = max(max_val, dp[i])
        # return(max_val)
        #The above approach is O(n^2) time complexity we can use binary search approach here
        def BinarySearch(l, r,target, dp):
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
        dp = [nums[0]]
        l = len(dp)-1
        for i in range(1, len(nums)):
            if nums[i]<=dp[l]:
                index = BinarySearch(0, l, nums[i], dp)
                #print(index,end=' ')
                dp[index] = nums[i]
                
            else:
                dp.append(nums[i])
                l+=1
            #print(l, end =' ')
            #print(dp)
        return l+1



        
