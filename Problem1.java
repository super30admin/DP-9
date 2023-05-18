//Time - > O(n^2)
//Space -> O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; 
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
 }

 //Time -> O(n)
 //Space -> O(n)
 //Optimized 
 class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; 
        int arr[] = new int[n];
        arr[0] = nums[0];
        int le = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > arr[le - 1]){
                arr[le] = nums[i];
                le++;
            }
            else{
                int bsIdx = binarySearch(arr, 0, le - 1, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return le;
    }
    private int binarySearch(int arr[],int l, int h, int target){
        while(l <= h){
            int mid = l +(h-l)/2;
            if(arr[mid] == target)
                return mid; 
            else if(arr[mid] > target){
                h = mid - 1;
            }
            else {
                l = mid+1;
            }
        }
        return l;
    }
}