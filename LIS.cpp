// Brute Force would be: each number has 2 options - choose/don't choose
// Once chosen, the index from where next can be chosen will be the next highest
// Can maintain a map with index of next highest

// DP
// Time Complexity : O(n^2); 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Init DP array with 1 since each el is a subseq
// 2. For each element, find all numbers less than it and update the cache value wherever psbl
// 3. Return max of cache array

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(!nums.size())
            return 0;
        vector<int> cache(nums.size(),1);
        // cache[0] = 1;
        for(int i=1; i<nums.size(); i++){
            // int best=0;
            // look if there is any smaller element in the left
            for(int j=i-1;j>=0;j--)
                // if small, choose small with best subseq val
                if(nums[i]>nums[j])
                    cache[i] = max(cache[i],1+cache[j]);
        }
        return *max_element(cache.begin(),cache.end());
    }
};