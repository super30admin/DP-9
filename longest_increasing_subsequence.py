class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        ## Approach 2: dp + binary search
        ## T.C = O(n.logn)
        ## S.C = O(n)

        n = len(nums)
        dp = [nums[0]]

        def binary_search(nums, target, low, high):
            while low <= high:
                mid = (low + high)//2
                if nums[mid] == target:
                    return mid
                elif nums[mid] < target:
                    low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
            
            return low

        for i in range(n):
            if nums[i] > dp[-1]:
                dp.append(nums[i])
            else:
                idx = binary_search(dp, nums[i], 0, len(dp))
                dp[idx] = nums[i]
            #print(dp)
        return len(dp)


        ## Approach 1: dp
        ## T.C = O(n.n)
        ## S.C = O(n)

        n = len(nums)
        dp = [1]*n
        mx = 1

        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(1 + dp[j], dp[i])
                    mx = max(mx, dp[i])
            #print(dp)

        return mx
