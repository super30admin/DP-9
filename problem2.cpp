#include<vector>
#include<iostream>

using namespace std;

//sorted O(nlogN) + O(N^2) for dp
// can be further optimized to nlogn with 
//the optimized long sequence algorithm.
// space complexity = O(N)

class Solution {
public:
    void display(vector<vector<int>> & gg){
        for(vector<int>& vec:gg){
            cout<<"["<<vec.at(0)<<","<<vec.at(1)<<"]"<<",";
        }
    }
    bool cmp(vector<int>& a, vector<int>& b){
        if(a.at(0)<b.at(0) && a.at(1)<b.at(1)) return true;
        return false;
    }
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        sort(envelopes.begin(),envelopes.end(),[](vector<int> a,vector<int> b)->bool{
            if(a.at(0) < b.at(0)){
                return true;
            }
            else if(a.at(0) == b.at(0)){
                if(a.at(1)<b.at(1)){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        });
        //display(envelopes);
        int sz = envelopes.size();
        vector<int> dp_arr(sz,1);
        int res{1};
        for(int i{1};i<sz;++i){
            for(int j{};j<i;++j){
                bool cmp_val = cmp(envelopes.at(j),envelopes.at(i));
                //cout<<cmp_val<<" ";
                if(cmp_val){
                    dp_arr.at(i) = max(dp_arr.at(i),dp_arr.at(j)+1);
                }
            }
            res = max(res,dp_arr.at(i));
        }
        return res;
    }
};