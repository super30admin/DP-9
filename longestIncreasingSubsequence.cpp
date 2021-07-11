// Time Complexity :O(nlogn) - n is the number of elements in vector
// Space Complexity : O(n)   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size() == 1) return 1;
        vector<int> arr(nums.size());
        arr[0] = nums[0];
        int len = 0;
        int maxVal = INT_MIN;
        for(int i = 1; i < nums.size();i++){
            if(nums[i] > arr[len]){
                len++;
                arr[len] = nums[i];
            }
            else{
                int index = binSearch(arr,0,len,nums[i]);
                arr[index] = nums[i];
            }
            maxVal = max(maxVal,len);
        }
        return maxVal+1;
    }
    int binSearch(vector<int> arr,  int low, int high,int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
};