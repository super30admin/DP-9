// Time complexity-O(nlogn)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// sort width in increasing order and sort height in descending order if the width is a tie
//  create an effective array to store a supposed version of the largest subsequence
// try to find the lower bound of that element which is just greater than the incomimg element
// replace the greater element with the incoming element in the resultant array
// the resultant array doesnt contain the actual LIS but its length is correct

/******************************************************binary-search*************************************************/


class Solution {
       
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if( envelopes.size()==0 ){return 0;}
        vector<int>arr;
        
      
        sort(envelopes.begin(),envelopes.end(),[](vector<int>&a,vector<int>&b)
                      { return a[0]==b[0] ? a[1]>b[1] : a[0]< b[0];});
        
        for(auto envelope: envelopes){
          auto it = lower_bound(arr.begin(),arr.end(),envelope[1]);
            
            if(it ==arr.end()){
                arr.push_back(envelope[1]);
            }
            else{
                *it =envelope[1];
            }
        }
        return arr.size();
        
    }
};



/********************************************************************************************************************/





/************************************************************************************dynamic programming*************************************/
class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if( envelopes.size()==0 ){return 0;}
        vector<int>dp(envelopes.size(),1);
        int maxim=1;
        sort(envelopes.begin(),envelopes.end(),[](vector<int>a,vector<int>b)
                      ->bool{ return a[0]==b[0] ? a[1]<b[1] : a[0]< b[0];});
        
        for(int i=1;i<dp.size();i++){
            for(int j=0;j<i;j++){
                if(envelopes[j][1]< envelopes[i][1]  && envelopes[j][0]!= envelopes[i][0]){
                    dp[i]= max(dp[i],dp[j]+1);
                }
            }
            maxim=max(maxim,dp[i]);
        }
        return maxim;
    }
};
/*********************************************************dynamic programming**************************************************/