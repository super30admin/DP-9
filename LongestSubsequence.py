#All TC passed on leetcode


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:

        #Here we use binary search. We keep appending num in nums to arr if cur num is greater than last element in arr. We its smaller then we perform binary search to find the right index position for that num in arr and insert it in that position. Finally the longest subsequence is the elements in the arr.
        #Time complexity - O(nlogn) 
        #Space complexity - O(n) - for storeing longest subsequence array
        n = len(nums)
        arr = []
        arr.append(nums[0])
        for i in range(1, n):
            if nums[i]>arr[-1]:
                arr.append(nums[i])
            else:
                idx = self.getRightIndex(nums[i], arr)
                arr[idx] = nums[i]

        return len(arr) 
            

    def getRightIndex(self, target, arr):
        l=0
        h=len(arr)-1

        while l<=h:
            mid = (l+h)//2

            if target == arr[mid]:
                return mid
            elif target>arr[mid]:
                l = mid+1
            else:
                h = mid-1
        return l


#----------------------------------------------OR------------------------------------------------

        #Here for every num we check if it has increasing subsequence with nums appearing before it by using the dp array. DP array stores values of the max subsequence possible uptill that index.
        #Time complexity - O(n^2) 
        #Space complexity - O(n) - for storeing dp array
        n = len(nums)
        dp = [1]*n
        maxLen = 1

        for i in range(1, n):
            for j in range(i):
                if nums[i]>nums[j]:
                    dp[i] = max(dp[i], dp[j]+1)
                maxLen = max(maxLen, dp[i])
        return maxLen
        