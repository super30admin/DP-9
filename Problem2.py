#time complexity o(n^2)
#space complexity o(n^2)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        dp = [[0] * (n) for _ in range(n)]

        for j in range(n):
            dp[n-1][j] = triangle[n-1][j]

        for i in range(n-2,-1,-1):
            for j in range(len(triangle[i])):
                dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j]
        
        return dp[0][0]