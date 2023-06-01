// Approach - DP
// Time Complexity -> O(n*logn) for sorting + O(n^2) for traversal.
// Space Comlexity - O(n)
class Solution {
    static bool cmp(const vector<int>& vec1, const vector<int>& vec2){
        return vec1[1] < vec2[1];
}
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        sort(envelopes.begin(), envelopes.end(), cmp);
        
        int n = envelopes.size();
        vector<int> v(n, 1);
        int answer = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    v[i] = max(v[i], 1 + v[j]);
                answer = max(v[i], answer);
            }
        }
        
        return answer;
    }
};

// Approach - Binary Search
// Time Complexity -> O(n*logn) for sorting + O(n*logn) for binary search on 'n' elements.
// Space Comlexity - O(n)
class Solution {
    static bool cmp(const vector<int>& vec1, const vector<int>& vec2){
        if(vec1[1] == vec2[1])
            return vec2[0] < vec1[0];
        return vec1[1] < vec2[1];
    }
    
    int bSearch(vector<int>& v, int k){
        int n = v.size();
        int low = 0;
        int high = n-1;
        int mid;
        
        while(low <= high){
            mid = low + (high - low)/2;
            
            if(v[mid] == k)
                return mid;
            else if(v[mid] < k)
                low = mid + 1;
            else
                high = mid -1;
        }
        
        return low;
    }
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        sort(envelopes.begin(), envelopes.end(), cmp);
        int n = envelopes.size();
        
        vector<int> v;
        v.push_back(envelopes[0][0]);
        
        for(int i = 0 ; i < n; i++){
            if(envelopes[i][0] < v.back()){
                // replace
                int idxReplace = bSearch(v, envelopes[i][0]);
                v[idxReplace] = envelopes[i][0];
            }
            else if(envelopes[i][0] > v.back())
                v.push_back(envelopes[i][0]);
                
            else continue;
        }
        
        return v.size();
    }
};