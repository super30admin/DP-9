/*
Time: O(nlogn)
Space: O(n)

Use inteligent subsequence building with binary search
*/

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
      vector<int> lis = {nums[0]};

      for(int i=1;i<nums.size();i++){
        int u = nums[i];
        if(u > lis[lis.size()-1])  lis.push_back(u);
        else{
            int replace_at = lower_bound(lis.begin(), lis.end(), u) - lis.begin();
            lis[replace_at] = u;
        }
      }

      return lis.size();
    }
};
