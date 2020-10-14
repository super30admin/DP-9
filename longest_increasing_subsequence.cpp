//Time Complexity-O(n^2)
//Space Complexity-O(n)
//Did the code run on Leetcode? Yes

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size()==0)
        {
            return 0;
        }
        vector<int>dp(nums.size(),1);
        for(int i=1;i<dp.size();i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    dp[i]=max(dp[i],dp[j]+1);
                }
            }
        }
        int res=*max_element(dp.begin(),dp.end());
        return res;
    }
};