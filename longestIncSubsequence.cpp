#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We try to build the longest sequence smartly by keeping only useful numbers.
If the number is larger than the last, we extend the effective array, otherwise we replace using binary search
The final length of this effective array gives us the LIS length
*/
class Solution{
public:
    int lengthOfLIS(vector<int>& nums){
        int n = nums.size();
        vector<int> arr(n);
        arr[0] = nums[0];
        int len = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] > arr[len - 1]){
                arr[len] = nums[i];
                len++;
            }else{
                int bsIdx = binarySearch(arr, 0, len -1, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return len;
    }

    int binarySearch(vector<int>& arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
};
