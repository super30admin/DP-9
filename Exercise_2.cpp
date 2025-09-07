// Time Complexity : O(n log n) : where n is the number of envelopes
// Space Complexity: O(n) : where n is the no of envelopes
// Were you able to solve it on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {

        if (envelopes.empty()){
            return 0;
        }

        if (envelopes.size() == 1){
            return 1;
        } 

        // sort elements according to width, if width are equal then sort according to height descending
        // this is to ensure that if we come across equal width then deal with the greater height first and discard on next equal width
        sort(envelopes.begin(), envelopes.end(), [](vector<int>&a, vector<int>&b) {
            if (a[0] == b[0]) return a[1] > b[1];
            return a[0] < b[0];
        });

        // create longest increasing subsequence based on increasing heights
        // using binary search approach for getting increasing heights
        int len=1;
        int n=envelopes.size();
        vector<int> sub;

        // push the first envelope height to the sub array
        sub.push_back(envelopes[0][1]);

        for(int i=1; i<n; i++) {
            // if the height is greater then add to sub array and increase len
            if (envelopes[i][1] > sub[len-1]  ) {

                sub.push_back(envelopes[i][1]);
                len++;
            }

            else {
                // search for next greater element and replace current element with it in the sub array
                int bsIndex = binarySearch(sub, 0, len-1, envelopes[i][1]);
                
                sub[bsIndex] = envelopes[i][1];
            }
        }

        return len;
    }
private:

    int binarySearch(vector<int>& sub, int low, int high, int target){

        while(low<=high) {
            int mid = low + (high - low) / 2;

            if (sub[mid] == target) return mid;
            else if (sub[mid] > target) high = mid -1;
            else low = mid+1;
        }
        return low;
    }

};