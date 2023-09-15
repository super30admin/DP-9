class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        #Method 1 - Exhaustive - Expo TC

        #Method 2 - DP - TC O(n^2) and SC O(n)
        # dp=[1 for _ in range(len(nums))]
        # for i in range(1,len(nums)):
        #     for j in range(i):
        #         if nums[i]>nums[j]:
        #             dp[i]=max(dp[j]+1,dp[i])
        # return max(dp)

        #Method 3 - Wierd iteration with binary search - TC - O(nLogn)
        if not nums:
            return 0

        n = len(nums)
        arr = [0] * n
        arr[0] = nums[0]

        def binarysearch(arr, low, high, target): #get the number just bigger than target for replacement
            while low <= high:
                mid = low + (high - low) // 2
                if arr[mid] == target:
                    return mid
                elif arr[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return low

        length = 1  # Initialize the length of LIS to 1

        for i in range(1, n):
            if nums[i] > arr[length - 1]: #if curr num bigger, just add it to the effective arr
                arr[length] = nums[i]
                length += 1
            else:
                bsindex = binarysearch(arr, 0, length - 1, nums[i]) #get the number just bigger than target for replacement
                arr[bsindex] = nums[i]

        return length