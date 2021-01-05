// Time Complexity: O(n^2) n = size of nums
// Space Complexity: O(n) size of dp vector will be n
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int maxlen = 1;
        vector<int> dp(nums.size(), 1);
        for(int i = 1; i < nums.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = max(dp[i], dp[j]+1);
                    maxlen = max(maxlen, dp[i]);
                }
            }
        }
        return maxlen;
    }
};


// Time Complexity: O(Nlog(N)) N = size of nums
// Space Complexity: O(N) max. possible size of temp vector will be N
class Solution {
public:
    int binarySearch(vector<int> temp, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2; // integer overflow
            if(temp[mid] == target) return mid;
            else if(temp[mid] > target) high = mid-1;
            else low = mid+1;  
        }
        return low;
    }
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        vector<int> temp;
        temp.push_back(nums[0]);
        for(int i = 1; i < nums.size(); i++) {
            if(nums[i] > temp.back())
                temp.push_back(nums[i]);
            else {
                int bIndex = binarySearch(temp, 0, temp.size()-1, nums[i]);
                temp[bIndex] = nums[i];
            }
        }
        return temp.size();
    }
};
