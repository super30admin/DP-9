#TC : O(N * N)
#SC: O(N)

def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1]*len(nums)
        for i in range(len(nums)):
            for j in range(i): 
                if nums[i] > nums[j] and dp[i] == dp [j]:
                    dp[i] += 1
        return max(dp)