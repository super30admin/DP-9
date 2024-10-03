// Time Complexity : O(n * log n)
// Space Complexity : O(n)
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if (nums.size() == 0)
        {
            return 0;
        }   

        vector<int> dp(nums.size(), 1);
        int max = 1;
        for (int j = 1; j < nums.size(); j++)
        {
            for (int i = 0; i < j; i++)
            {
                if (nums[i] < nums[j])
                {
                    dp[j] = std::max(dp[j], dp[i] + 1);
                    max = std::max(max, dp[j]);
                }
            }
        }

        return max;
    }
};
