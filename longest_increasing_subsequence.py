## Time - O(n**2)
## Space - O(n)
## Des - since decision making parameter is 1, maintain a 1-D array(dp) and iterate through the array to know the number of values that are lesser and increase the value at dp array position by considering the max of those two values
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # dp=[1]*len(nums)
        # for i in range(len(nums)):
        #     for j in range(0,i):
        #         if nums[i]>nums[j]:
        #             dp[i]=max(dp[i],dp[j]+1)
        # return max(dp)

        ############# Binary Search #############
        ### time - O(nlongn)
        ### space-O(n)
        #         arr=[0]*len(nums)
        #         arr[0]=nums[0]
        #         l=1
        #         def binarysearch(arr,low,high,target):
        #             while low<=high:
        #                 mid=low+(high-low)//2
        #                 if target==arr[mid]:
        #                     return mid
        #                 elif target>arr[mid]:
        #                     low=mid+1
        #                 else:
        #                     high=mid-1
        #             return low

        #         for i in range(1,len(nums)):
        #             if nums[i]>arr[l-1]:
        #                 arr[l]=nums[i]
        #                 l+=1
        #             else:
        #                 val=binarysearch(arr,0,l-1,nums[i])
        #                 arr[val]=nums[i]
        #         return l

        ######### Using bisect in python similar to BS #########
        ### time - O(nlongn)
        ### space-O(n)
        import bisect
        arr = []
        for i in range(len(nums)):
            l = bisect_left(arr, nums[i])
            if l == len(arr):
                arr.append(nums[i])
            else:
                arr[l] = nums[i]
            # print(arr)
        return len(arr)

