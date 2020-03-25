//Time Complexity-O(n^2)
//Space Complexity-O(n)--> number of envelopes
//Did the code execute on Leetcode? Yes

class Solution {
public:
    static bool cmp(vector<int>a,vector<int>b)
    {
        return a[0]<b[0];
    }
    
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if(envelopes.size()==0)
        {
            return 0;
        }
        sort(envelopes.begin(),envelopes.end(),cmp);
        vector<int>dp(envelopes.size(),1);
        for(int i=1;i<dp.size();i++)
        {
            for(int j=0;j<i;j++)
            {
                if(envelopes[i][1]>envelopes[j][1] && envelopes[i][0]>envelopes[j][0])
                {
                    dp[i]=max(dp[i],dp[j]+1);
                }
            }
        }
        int maximum=0;
        for(int i=0;i<dp.size();i++)
        {
            maximum=max(maximum,dp[i]);
        }
        return maximum;
    }
};