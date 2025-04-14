// Time Complexity: O(nlogn)
// Space Complexity: O(n)
// Did you run the code on LeetCode? Yes

// Approach:
// 1. Sort the envelopes by width in ascending order. If two envelopes have the same width, sort them by height in descending order.
// 2. Create an array heights to store the heights of the envelopes after sorting.
// 3. Initialize a vector lis to store the longest increasing subsequence of heights. The first element is set to the first height.
// 4. Iterate through the heights array. For each height, check if it is greater than the last element in lis.
//    - If it is, append it to lis and increment the index.
//    - If it is not, perform a binary search to find the position where it can replace an element in lis.
// 5. The length of lis at the end of the iteration will be the length of the longest increasing subsequence of heights, which is the maximum number of envelopes that can be Russian-dolled together.

class Solution {
    public:
        int maxEnvelopes(vector<vector<int>>& envelopes) {
            //sorting envolpes by width, and if conflict, decreasing height
            sort(envelopes.begin(), envelopes.end(), [](const vector<int>& a, const vector<int>& b){
                if(a[0] == b[0]){return a[1] > b[1];}
                return a[0] < b[0];
            });
            vector<int> heights(envelopes.size());
            for(int i = 0; i < envelopes.size(); i++){
                heights[i] = envelopes[i][1];
            }
    
            vector<int> lis(envelopes.size());
            lis[0] = heights[0];
            int idx = 1;
    
            for(int i = 1; i < envelopes.size(); i++){
                if(heights[i] > lis[idx - 1]){
                    lis[idx] = heights[i];
                    idx++;
                }else{
                    int bsIdx = binarySearch(lis, 0, idx - 1, heights[i]);
                    lis[bsIdx] = heights[i];
                }
            }
            return idx;
        }
    private: 
        int binarySearch(vector<int>& effective, int low, int high, int target){
            while(low <= high){
                int mid = low + (high - low)/2;
                if(effective[mid] == target){
                    return mid;
                }else if(effective[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return low;
        }
    };