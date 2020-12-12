class Solution {
public:
    static bool comp(vector<int>& a, vector<int>& b) {
        return a[0]<b[0];
    }
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if (envelopes.size()==0) return 0;
        sort(envelopes.begin(),envelopes.end(),comp);
        // for (auto x:envelopes) {
        //     for (auto y:x) {
        //         cout<<y<<" ";
        //     }
        //     cout<<endl;
        // }
        vector<int> dp(envelopes.size(),1);
        int maxi=1;
        for (int i=0;i<envelopes.size();i++) {
            for (int j=0;j<i;j++) {
                if (envelopes[j][1]<envelopes[i][1] && envelopes[j][0]<envelopes[i][0] && dp[j]+1>dp[i]) {
                    dp[i]=dp[j]+1;
                    maxi=max(maxi,dp[i]);
                }
            }
        }
        return maxi;
    }
};