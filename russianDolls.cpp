// DP
// Time Complexity : O(n^2); 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Sort the vector based on widhts 
// 2. Then it is equivalent to finding LIS on heights
// 3. Just ensure that the widths also have to be increasing i.e. [6,4] can't go into [6,7]

class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if(envelopes.size() == 0)
            return 0;
        // sort based on width
        sort(envelopes.begin(), envelopes.end(), [](const vector<int>& a, const vector<int>& b){
            return a[0]<b[0];
        });
        vector<int> cache(envelopes.size(),1);
        // Find Longest Increasing Subsequence on heights while ensuring that the widths are also increasing
        for(int i=0;i<cache.size();i++){
            for(int j=0;j<i;j++){
                                                        // to avoid equal widths
                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0])
                    cache[i] = max(cache[i], 1+cache[j]);
            }
        }
        return *max_element(cache.begin(), cache.end());
    }
};