// https://leetcode.com/problems/longest-increasing-subsequence/description/

// DP Solution
// Time Complexity: O(n*n)
// Space Complexity: O(n)

class Solution {
    public:
        int lengthOfLIS(vector<int>& nums) {
            int n = nums.size();
            int lis = 1;
            vector<int> dp(n,1);
            for(int i=1; i<n; i++){
                for(int j=0; j<i; j++){
                    if(nums[i]>nums[j]){
                        dp[i] = max(dp[i], dp[j]+1);
                        lis = max(lis, dp[i]);
                    }
                }
            }
            return lis;
        }
    };

// Binary Search Solution
// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Solution {
    public:
        int lengthOfLIS(vector<int>& nums) {
           int n = nums.size();
           vector<int> ans;
           for(auto num : nums){
                auto it = lower_bound(ans.begin(), ans.end(), num);
                if(it == ans.end()){
                    ans.push_back(num);
                }
                else{
                    *it = num;
                }
           }
           return ans.size();
        }
    };

