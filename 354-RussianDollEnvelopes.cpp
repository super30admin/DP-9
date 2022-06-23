/* 
    Time Complexity                              :  O(N*N) - dynamicProgramming
                                                    O(N Log N) - maxEnvelopesOptimized
    Space Complexity                             :  O(N) - to store the values in the dp array
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
private:
    static bool cmp(const vector<int>& a, const vector<int>& b) {
        return a[0]==b[0] ? a[1] > b[1] : a[0] < b[0];
    }
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        return maxEnvelopesOptimized(envelopes);
        // return dynamicProgramming(envelopes);
    }
    // O(N*N) hence time limit exceeded
    int dynamicProgramming(vector<vector<int>>& env) {
        int n = env.size();
        sort(begin(env),end(env),cmp);
        vector<int> dp(n,1);
        int mx = 1;
        for(int i=1;i<n;i++) {
            for(int j=0; j<i;j++) {
                if(env[i][1] > env[j][1]) {
                    dp[i] = max(dp[i],dp[j] + 1);
                }
            }
            mx = max(mx, dp[i]);
        }
        
        return mx;
    }
    
    
    // O(N log N) since used binary search
    int maxEnvelopesOptimized(vector<vector<int>>& envelopes) {
        
        auto cmp = [](vector<int>& a, vector<int>& b) { 
            return a[0]==b[0] ? a[1] > b[1] : a[0] < b[0];
        };
        sort(begin(envelopes), end(envelopes), cmp);
        int n = envelopes.size();
        vector<int> dp;
        dp.push_back(envelopes[0][1]);
        for(int i=1;i<n;i++) {
            if(envelopes[i][1] > dp.back()) {
                dp.push_back(envelopes[i][1]);
            } else {
                int bsIndex = binarySearch(dp,0,dp.size()-1,envelopes[i][1]);
                // int bsIndex = lower_bound(dp.begin(),dp.end(),envelopes[i][1]) - dp.begin();
                dp[bsIndex] = envelopes[i][1];
            }
        }
        return dp.size();
    }
    
    
    int binarySearch(vector<int>& dp, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(dp[mid] == target) {
                return mid;
            } else if(dp[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
};