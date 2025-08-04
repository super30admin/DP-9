# Time Complexity: O(n^2)
# Space Complexity: O(n) 

def maxEnvelopes(envelopes):
    envelopes.sort(key=lambda x: (x[0], -x[1]))
    heights = [env[1] for env in envelopes]
    dp = [1] * len(heights)

    for i in range(1, len(heights)):
        for j in range(i):
            if heights[i] > heights[j]:
                dp[i] = max(dp[i], dp[j] + 1)

    return max(dp)
