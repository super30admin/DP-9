# Time:- O(nlogn)
# Space:- O(1)
# Approach:- Using binary search to find the positions where an element should be placed if the 
# property of increasing subsequence is violated. It is because it doesnt matter what the previous subsequence was in the past when we encounter an element which is smaller than the 
# current element we should discard the element just greater than this element in the sequence 
# we have seen till now and check the subsequent elements with this updated sequence.
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # maxnum=1
        # dp=[1]*len(nums)
        # for i in range(len(nums)):
        #     for j in range(i):
        #         if nums[i]>nums[j]:
        #             dp[i]=max(dp[i],dp[j]+1)
        #             maxnum=max(maxnum,dp[i])
        # return maxnum
        bs_array=[nums[0]]
        def bs(bs_array,element):
            low=0
            hi=len(bs_array)-1
            while(low<=hi):
                mid=low+hi>>1
                if bs_array[mid]==element:
                    return mid
                if bs_array[mid]>element:
                    hi=mid-1
                else:
                    low=mid+1
            return low
            
        for i in range(1,len(nums)):
            # element is smaller than the last element in the increasing subsequence
            if bs_array[-1]>=nums[i]:
                # find the index of the element which is just greater than this element
                idx=bs(bs_array,nums[i])
                bs_array[idx]=nums[i]
            else:
                # we can append the elemnent to the subsequence
                bs_array.append(nums[i])
        # the length of the subsequence we have seen till now is the longest increasing subsequence
        return len(bs_array)