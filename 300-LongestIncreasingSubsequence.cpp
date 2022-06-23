/* 
    Time Complexity                              :  O(N*N) - dynamicPrograaming
                                                    O(N Log N) - optimized
    Space Complexity                             :  O(N) to store in the dp array
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        // return dynamicProgramming(nums);
        return optimized(nums);
    }
    
    int dynamicProgramming(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n,1);
        int mx = 1;
        
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = max(dp[i],dp[j]+1);
                }
            }
            mx = max(mx, dp[i]);
        }
        
        return mx;
    }
    
    int optimized(vector<int>& nums) {
        int n = nums.size(), len=0;
        vector<int> dp(n);
        dp[len] = nums[0];
        for(int i=1;i<n;i++) {
            int csz = dp.size()-1;
            if(nums[i] > dp[len]) {
                dp[len+1] = nums[i];
                len++;
            } else {
                int bsIndex = binarySearch(dp, 0, len, nums[i]);
                // int bsIndex = lower_bound(begin(dp), end(dp), nums[i]) - begin(dp);
                dp[bsIndex] = nums[i];
            }
        }
        
        return len+1;
    }
    
    int binarySearch(vector<int>& nums, int low, int high, int target) {
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        
        return low;
    }
};