// Time Complexity: O(nlogn)
// Space Complexity: O(n)
// Did you run the code on LeetCode? Yes

// Approach: 
// 1. Create an array effective to store the longest increasing subsequence found so far.
// 2. Iterate through the input array nums. For each element, check if it is greater than the last element in effective.
//    - If it is, append it to effective and increment the index.
//    - If it is not, perform a binary search to find the position where it can replace an element in effective.
// 3. The length of effective at the end of the iteration will be the length of the longest increasing subsequence.
// 4. The binary search is used to find the position where the current element can replace an element in effective, ensuring that effective remains sorted.

class Solution {
    public:
        int lengthOfLIS(vector<int>& nums) {
            int n = nums.size();
            vector<int> effective(n);
            effective[0] = nums[0];
            int idx = 1;
            for(int i = 1; i < n; i++){
                if(nums[i] > effective[idx - 1]){
                    effective[idx] = nums[i];
                    idx++;
                }else{
                    int bsIdx = binarySearch(effective, 0, idx - 1, nums[i]);
                    effective[bsIdx] = nums[i];
                }
            }
            for(int i : effective){
                cout << i<< " ";
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