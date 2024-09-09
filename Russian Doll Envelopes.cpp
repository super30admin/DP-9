//see 300. to understand better
//time: O(nlogn)
//space: O(n)
class Solution {
    int bs(int low, int high, int target, vector<int>& effective) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(effective[mid] == target) return mid;
            else if(effective[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }
        return low;
    }
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        sort(envelopes.begin(), envelopes.end(), [](vector<int> &a, vector<int> &b){
            if(a[0] == b[0]) {
                return a[1] > b[1];
            }
            return a[0] < b[0];
        }); // ascending, but descending if equal - so that we do not take multiple if same width diff heights

        // now greedy + bs on heights

        int n = envelopes.size();
        vector<int> effective;
        effective.push_back(envelopes[0][1]);
        int len = 1;
        for(int i = 1; i < n; i++) {
            if(envelopes[i][1] > effective[len - 1]) {
                effective.push_back(envelopes[i][1]);
                len++;
            }
            else {
                int idx = bs(0, len - 1, envelopes[i][1], effective);
                effective[idx] = envelopes[i][1];
            }
        }
        return len;
    }
};