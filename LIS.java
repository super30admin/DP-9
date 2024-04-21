// Time Complexity : O(n^2)
// Space Complexity : O(n) - dp matrix

// Did this code successfully run on Leetcode : yes

// Approach: Go exhaustive and find all the possible subsequence, use dp to optimize the repeated subproblems. A bigger number can be used in the previous subsequences.

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1); // each number in itself is increasing subsequence
        int max = 1;

        for(int i = 1 ; i < n ; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){ //strictly increasing
                    dp[i] = Math.max(1+dp[j] , dp[i]);
                    max = Math.max(dp[i],max);
                }
            }
        }

        return max;
    }
}


// Time Complexity : O(nlogn) - worst case do binary search for each number
// Space Complexity : O(n) 

// Did this code successfully run on Leetcode : yes

// Approach: find effective increasing subsequence.The length remains correct because the length only changes when a new element is larger than any element in the subsequence. In that case, the element is appended to the subsequence instead of replacing an existing element.
//for each element num, if num is greater than the largest element in our subsequence, then add it to the subsequence. Otherwise,  replace the first element that is greater than or equal to num with num. 
//This opens the door for elements that are greater than num but less than the element replaced to be included in the sequence.

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n]; // effective increasing subsequence.
        arr[0] = nums[0];
        int le = 1; // traverse on arr & tells the length of effective increasing subsequence.

        for(int i = 1; i < n ; i++){
            if(nums[i] > arr[le-1]){ //contribute to the increasing subsequence
                arr[le] = nums[i];
                le++;
            }
            else{
                int bsIdx = binarySearch(arr,0, le-1, nums[i]); 
                arr[bsIdx] = nums[i];
            }
        }

        return le;        
    }

    //get the next big element
    private int binarySearch(int[] arr , int lo , int hi , int target){

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(arr[mid] == target){
                return mid;
            }
            else if( arr[mid] > target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }

        return lo; // next big number
    }
}