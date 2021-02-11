//Time - O(n^2)
//Space - O(n)
class Solution {
public:
    
    bool static comp(vector<int>& a, vector<int> b){
        return a[0]<b[0];
    }
    
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if(envelopes.size()==0) return 0;
        sort(envelopes.begin(),envelopes.end(),comp);
        int m = 1;
        vector<int> dp (envelopes.size(),1);
        
        for(int i=1;i<envelopes.size();i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][1]>envelopes[j][1] && envelopes[i][0]>envelopes[j][0]){
                    dp[i] = max(dp[i], dp[j]+1);
                    m = max(m, dp[i]);
                } 
            }
        }
        
        return m;
        
    }
};