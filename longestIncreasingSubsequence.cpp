class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> ans(nums.size(),1);
        int maxi=1;
        for (int i=1;i<nums.size();i++) {
            for (int j=0;j<i;j++) {
                if (nums[i]>nums[j] && ans[j]+1>ans[i]) {
                    ans[i]=ans[j]+1;
                    maxi=max(ans[i],maxi);
                }
            }
        }
        return maxi;
    }
};