class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] seq = new int[n];
        int top=-1;
        for(int i=0;i<n;i++){
            if(top==-1 || nums[i]>seq[top]){
                seq[++top] = nums[i];
            }
            else{
                int idx = binarySearch(seq,nums[i],top);
                seq[idx]=nums[i];
            }
        }
        return top+1;
    }
    private int binarySearch(int[] seq, int num, int high){
        int low=0;
        while(low<high){
            int mid = low + (high-low)/2;
            if(seq[mid]==num){
                return mid;
            }
            else if(seq[mid]>num){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
