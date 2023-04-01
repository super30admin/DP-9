354. Russian Doll Envelopes


Time complexity:O(nlog(n))
Space complexity:O(n)


class Solution {
public:
    static bool cmp(const vector<int>& v1, const vector<int>& v2)
    {
      if(v1[0] == v2[0]) return v1[1] > v2[1];
            return v1[0]<v2[0];
    }
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        int n = envelopes.size();
        sort(envelopes.begin(),envelopes.end(),cmp);
        vector<int>arr;
        for(int i =0;i<n;i++)
        {
            if(arr.empty() || arr.back()<envelopes[i][1])
                arr.push_back(envelopes[i][1]);
            else
            {
                int index = lower_bound(arr.begin(),arr.end(),envelopes[i][1])
                        -   arr.begin();
                arr[index] = envelopes[i][1];
            }
        }
        
        return arr.size();
    }
};



