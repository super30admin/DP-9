// Approach 1: DP with 2 pointers
// TC: O(n^2)
// SC: O(n)

// You try drawing all possible permuatations (choose-not choose) to find the largest subsequence (2^n) solution
// You will find repeated subproblems from this which will give a  DP intuition
// Since every element is a subsequence of itself (length 1), we start with the dp array and fill it with '1'.
// You start i=1 and j=0
// If ith element is > jth element meaning its a possible subsequence, your your dp[i] would be the dp[j]+1 because
// dp[j] has its own subsequence and with the ith element you add another element to the subsequence so the length increases by 1
// However do a max length value because dp[i] could already be > than dp[j]+1
// When the above condition is satisfied, and i is incremented, j resets at index 0 and j is incremented again until its < i

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int max=1; //because all individual element subsq. count is 1 at the start
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}


// Approach 2: Intelligent Binary Search 
// TC: O(n log n)
// SC: O(n)

// Here also you form another array called as effective subsequence array
// You start i at index 1, add the 0th element already to the effective array
// Compare ith element with the last element of effective array 
// If ith element is greater, simply add it to the effective array else
// Replace the element just greater than the ith element in the effective array 
// Now to find this element 'just greater than' ith element, we use binary search
// Target is the ith element however binary search low pointer will end up getting us the index of the element
// just larger than nums[i] in the effective array

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        arr[0]=nums[0]; //add first element to effective array
        int le=1; //initial length of effective array
        
        for(int i=1;i<n;i++){ //start i from 1
            
            if(nums[i]>arr[le-1]){ // if element > last element in effective array
                arr[le]=nums[i]; //add the element to effective array
                le++; //increment length
            } else{ //otherwise 
                int bsIdx=binarySearch(arr,nums[i],0,le-1); //replace element just > than nums[i]
                arr[bsIdx]=nums[i];
            }
        }
        return le;
    }
    private int binarySearch(int[] arr,int target,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<target){
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return low;
    }
}