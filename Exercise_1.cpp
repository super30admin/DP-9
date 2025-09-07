// Time Complexity: O(n log n) where n is no of elements
// Space Complexity: O(n) where n is no of elements
// Were you able to solve it on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {

        if (nums.empty()) return 0;

        if(nums.size() == 1) return 1;

        int n = nums.size();

        // Greedy Binary Search
        vector<int> sub;

        // push the first element into the sub array
        sub.push_back(nums[0]);
        // initialize the longest length as 1
        int len=1;
        
        // iterate through all elements of the array
        for(int i=1; i<n; i++) {
            // if current element is greater than element at last index of the sub array, then add into the sub array
            // making it as a increasing subsequence, increment len pointer to keep track of the end
            if (nums[i] > sub[len-1]) {
                sub.push_back(nums[i]);
                len++;

            } else {
                // if curr element is not greater then perform binary search within the array to find the index of next greater element
                // replace the element returned with the current element in the sub array
                int bsIndex = binarySearch(sub,0, len-1, nums[i]);
                sub[bsIndex] = nums[i];

            }
        }

        return len;

        // DP based approach
        // vector<int> dp(n, 1);
        // int res=1;

        // for(int i=1; i<n; i++) {
        //     for(int j=0;j<i;j++) {
        //         if (nums[i] > nums[j] ){
        //             dp[i] = max(dp[i], dp[j] + 1);
                    
        //         }
                
        //     }
        //     res= max(dp[i], res);
        // }    
        
        // return res;
    }

private:

    int binarySearch(vector<int>& sub, int low, int high, int target){
        // perform binary search to return index of the target
        while(low<=high) {
            int mid = low + (high - low) / 2;

            if (sub[mid] == target) return mid;
            else if (sub[mid] > target) high = mid -1;
            else low = mid+1;
        }
        return low;
    }
};