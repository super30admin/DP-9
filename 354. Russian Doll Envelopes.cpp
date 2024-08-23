/*
Time: O(nlogn)
Space: O(n)

2 Steps:
    1. sort (ascendingly on the width, break tie by decreasing order of heights)
    2. LIS for height by intelligent subsequence choosing (nlogn)
*/

class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& e) {
        //sort ascendingly on the width first, break tie by decreasing order of heights
        //sorting descendingly on height means the for a particular width w, if we select a height h and then do LIS, same width w's another height can't be bigger than h -> means only one height will be chosen for each weight group 
        sort(e.begin(), e.end(), [](vector<int> &a, vector<int> &b){
            if(a[0] == b[0])  return a[1] > b[1];
            return a[0] < b[0];
        });


        //Now do LIS by intelligent subsequence choosing (nlogn)
        vector<int> lis;

        for(auto &v: e){
            int u = v[1];

            if(lis.empty() || lis[lis.size()-1] < u)  lis.push_back(u);
            else{
                int replace_idx = lower_bound(lis.begin(), lis.end(), u) - lis.begin(); 
                lis[replace_idx] = u;
            }
        }

        return lis.size();
    }
};
