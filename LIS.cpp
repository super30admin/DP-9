/*
Intuition: 
////////////////////////////////////////////////////
Sol 1: At every element, check if all previous elements are lesseer. Record length using DP
Time Complexity: O(N^2)
Space Complexity: O(N)
////////////////////////////////////////////////////
Sol 2: Build a potential subsequence using binary search. If the incoming element is greater add it to potential subsequence.
Else do binary search and put the element in the subsequence.
Time Complexity: O(NlogN)
Space Complexity: O(N)
////////////////////////////////////////////////////
*/

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> dp(nums.size(), 1);
        int result = 1;
        
        for ( int i = 1; i < nums.size(); i++){
        
            for ( int j = 0; j < i; j++){
                
                if ( nums[i] > nums[j]){
                    
                    dp[i] = max( dp[i], dp[j] + 1);
                                        
                }
                result = max( result, dp[i]);;
                
            }
        
        }
        
        
        return result;
    }
};


class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        
        vector<int> subsequence;
        subsequence.push_back(nums[0]);
        
        int len = 1;
        for ( int i = 1; i < nums.size(); i++){
            
            if ( nums[i] > subsequence[len-1]){
                
                subsequence.push_back(nums[i]);
                len++;
            }
            else{
                int index = BSIndex(subsequence, 0, len-1,nums[i]);
                subsequence[index] = nums[i];

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