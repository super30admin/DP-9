// Time Complexity :O(nlogn) - To sort
// Space Complexity : O(n) - DP Row   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*bool myCompare(vector<int> a, vector<int> b){
    if(a[0] == b[0]) return a[1] > b[1];
    return a[0] < b[0];
}
class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        sort(envelopes.begin(),envelopes.end(),myCompare);
        int maxVal = INT_MIN;
        int arr[envelopes.size()];
        arr[0] = envelopes[0][1];
        int len = 0;
        for(int i = 1; i < envelopes.size();i++){
            if(arr[len] < envelopes[i][1]){
                len++;
                arr[len]= envelopes[i][1];
            }
            else {
                int index = binSearch(arr,0,len,envelopes[i][1]);
                arr[index] = envelopes[i][1];
            }
        }
        return len+1;
    }
    int binSearch(int arr[], int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
};*/
bool myCompare(vector<int> a, vector<int> b){
    if(a[0] == b[0]) return a[1] > b[1];
    return a[0] < b[0];
}
class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        vector<int> dp(envelopes.size(),1);
        int maxVal = INT_MIN;
        sort(envelopes.begin(),envelopes.end(),myCompare);
        for(int i =1;i<envelopes.size();i++){
            for(int j = 0; j < i;j++){
                if(envelopes[i][1] > envelopes[j][1]){
                    dp[i] = max(dp[i],1+dp[j]);
                }
            }
            maxVal = max(maxVal,dp[i]);
        }
        return maxVal < 0 ? 1:maxVal;
    }
};