/*
Intuition: 
////////////////////////////////////////////////////
Sol 1: At every element, check if all previous elements are lesseer. Record length using DP
In this way we can put a new envelope into the previous envelope.
Sort the array before we process it.
Time Complexity: O(N^2)
Space Complexity: O(N)
////////////////////////////////////////////////////
Sol 2: Sort the array before we process it.
Build a potential subsequence using binary search. If the incoming element is greater add it to potential subsequence.
Else do binary search and put the element in the subsequence.
Time Complexity: O(NlogN)
Space Complexity: O(N)
////////////////////////////////////////////////////
*/


bool comparator(vector<int>a, vector<int> b){
    return a[0] < b[0];
}

class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        sort(envelopes.begin(), envelopes.end(), comparator);
        for ( auto el:envelopes ){
            for ( auto e: el){
                cout<<e;
            }
            cout<<endl;
        }
        vector<int> dp(envelopes.size(), 1);
        
        int result = 1;
        
        for (int i =1; i < envelopes.size(); i++){
            for (int j=0; j < i; j++){
                if ( envelopes[j][1] < envelopes[i][1] and envelopes[j][0] < envelopes[i][0]){
                    dp[i] = max( dp[i], dp[j]+ 1);
                    
                }
                result = max( result, dp[i]);
            }
        }
        
        
        return result;
        
        
    }
};


bool comparator(vector<int> a, vector<int> b){
    if ( a[0] == b[0]){
        return a[1] > b[1];
    }
    return a[0] < b[0];
}
class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        sort( envelopes.begin(), envelopes.end(), comparator);
        for ( auto env: envelopes){
            for ( auto e: env){
                cout<<e;
            }
            cout<<endl;
        }
        vector<int> subsequence;
        subsequence.push_back(envelopes[0][1]);
        
        int len = 1;
        for ( int i = 1; i < envelopes.size(); i++){
            
            if ( envelopes[i][1] > subsequence[len-1] ){
                
                subsequence.push_back(envelopes[i][1]);
                len++;
            }
            else{
                int index = BSIndex(subsequence, 0, len-1,envelopes[i][1]);
                subsequence[index] = envelopes[i][1];

            }
            
        }
        
        return len;
        
    }
    int BSIndex(vector<int> subsequence, int low, int high , int target){
        
        while ( low <= high){
            int mid = low + ( high - low) /2;
            if ( subsequence[mid] == target) return mid;
            if ( subsequence[mid] > target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
        
        
    }
};