/*  TC = O(logn) using effective array pattern and binary search
SC = O(n)  */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int m = nums.length;
        int[] effective = new int[m];
        effective[0] = nums[0];
        int le = 1;
        for(int i=1;i<m;i++){
            if(nums[i]>effective[le-1]){
                effective[le] = nums[i];
                le++;
            }else{
                int bsIdx = binarySearch(0,le-1,effective,nums[i]);
                effective[bsIdx] = nums[i];
            }
        }
        return le;
    }
    private int binarySearch(int low, int high, int[] effective, int target){
        
        while(low<=high){
            int mid = low + (high - low)/2;
            if(target == effective[mid]){
                return mid;
            }else if(target > effective[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}