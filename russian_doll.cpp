// Time Complexity : O(n2)
// Space Complexity : O(n)
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1. Convert to 2d to 1d LIS by sorting
//2. Then do the dp and find the maximum LIS
//3. return max_count


bool sortcol(vector<int>& v1, vector<int>& v2){
    return v1[0] < v2[0]; 
}

class Solution {
public:
   
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        //edge
        if(envelopes.size()==0){
            return 0;
        }
        
        sort(envelopes.begin(), envelopes.end(), sortcol);
        int size = envelopes.size();
        
        vector<int> dp(size, 1);
         int max_count = 1;
        for(int i=1; i<size; i++){
            for(int j=0; j<i; j++){
                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]){
                    dp[i] = max(dp[i] , dp[j]+1);
                }
                if(max_count<dp[i]){
                   max_count =dp[i];
               }
            }
        }
        return max_count;
    }
};


// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Any problem you faced while coding this :
//Understand sorting of the envelopes
//First sort wrrt one parameter consider width increasing
//Second sort wrt height increasing

//Add into the when greater than previous height
//Replace when less than previous height

// Your code here along with comments explaining your approach



bool sortcol(vector<int>& v1, vector<int>& v2){
    if(v1[0] == v2[0])
        return v1[1] > v2[1];
    return v1[0] < v2[0];
}

class Solution {
public:
   
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        //edge
        if(envelopes.size()==0){
            return 0;
        }
        
        sort(envelopes.begin(), envelopes.end(), sortcol);
        int size = envelopes.size();
        
        vector<int> dp;
        dp.push_back(envelopes[0][1]);
        int dp_index=0;
        
        for(int j=1; j<size; j++){
            if(envelopes[j][1] > dp[dp_index] ){
                dp.push_back(envelopes[j][1]);
                dp_index++;
            }else{
                int idx = bin_search(dp, 0, dp_index-1, envelopes[j][1]);
                dp[idx] = envelopes[j][1];
            }
        }
        
        return dp.size();
    }
    
    int bin_search(vector<int>& dp, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(dp[mid] ==target){
                return mid;
            }else if(dp[mid]> target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    
};


