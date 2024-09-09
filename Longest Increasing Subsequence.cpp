//effective increasing subsequence - greedy + bs
// https://leetcode.com/problems/longest-increasing-subsequence/solutions/1326308/c-python-dp-binary-search-bit-segment-tree-solutions-picture-explain-o-nlogn/

//time: O(nlogn)
//space: O(n)
class Solution {
    int bs(int low, int high, int target, vector<int>& effective) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(effective[mid] == target) return mid;
            else if(effective[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
            //cout<<low<<" "<<mid<<" "<<high<<endl;
        }
        return low;
    }
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> effective;
        effective.push_back(nums[0]);
        int len = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] > effective[len - 1]) {
                effective.push_back(nums[i]);
                len++;
                //cout<<nums[i]<<endl;
            }
            else {
                int idx = bs(0, len - 1, nums[i], effective);
                effective[idx] = nums[i];
                //cout<<idx<<" "<<nums[i]<<" "<<len<<endl;
            }
        }
        return len;
    }
};