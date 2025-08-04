"""
Let dp[i] be the length of the LIS ending at index i
For each i, check all j < i and update dp[i] = max(dp[i], dp[j] + 1) if nums[i] > nums[j]
The answer is max(dp)
"""
"""
Time Complexity: O(n^2)	Double loop over nums
Space Complexity: O(n)	For dp array
"""

class longestSubseq:
    def lengthOfLIS(self, nums: list[int]) -> int:
        n = len(nums)
        dp = [1] * n

        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)

        return max(dp)
    
if __name__ == "__main__":
    obj = longestSubseq()
    print(obj.lengthOfLIS([10,9,2,5,3,7,101,18])) 
    print(obj.lengthOfLIS([0,1,0,3,2,3]))    
    print(obj.lengthOfLIS([7,7,7,7,7,7,7]))
