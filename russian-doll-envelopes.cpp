// Time Complexity: O(n^2) n = size of envelopes
// Space Complexity: O(n) size of dp vector will be n
class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if(envelopes.size() == 0) return 0;
        sort(envelopes.begin(), envelopes.end());
        int maxlen = 1;
        vector<int> dp(envelopes.size(), 1);
        for(int i = 1; i < envelopes.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] != envelopes[i][0]) {
                    dp[i] = max(dp[i], dp[j]+1);
                    maxlen = max(maxlen, dp[i]);
                }
            }
        }
        return maxlen;
    }
};


// Time Complexity: O(Nlog(N)) N = size of envelopes
// Space Complexity: O(N) max. possible size of temp vector will be N
class Solution {
public:
    int binarySearch(vector<int> temp, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2; // integer overflow
            if(temp[mid] == target) return mid;
            else if(temp[mid] > target) high = mid-1;
            else low = mid+1;  
        }
        return low;
    }
    static bool myCompare(vector<int> a, vector<int> b) {
        return (a[0] != b[0]) ? a[0] < b[0] : a[1] > b[1];
    }
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if(envelopes.size() == 0) return 0;
        sort(envelopes.begin(), envelopes.end(), myCompare);
        vector<int> temp;
        temp.push_back(envelopes[0][1]);
        for(int i = 1; i < envelopes.size(); i++) {
            if(envelopes[i][1] > temp.back())
                temp.push_back(envelopes[i][1]);
            else {
                int bIndex = binarySearch(temp, 0, temp.size()-1, envelopes[i][1]);
                temp[bIndex] = envelopes[i][1];
            }
        }
        return temp.size();
    }
};
