class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int length = 1; //lgt of current LIS
        for(int i = 1; i < n ; i++){
            if( nums[i] > arr[length-1]){ //if current num at index i is greater than the last element in till now LIS , add it to the array and increase length
                arr[length] = nums[i];
                length++;
            }
            else{
                //replace the current num with it's immediate greatest num in LIS array 
                int index = binarysearch(arr , 0 , length , nums[i]); //with binary search finding out which index ishas immediate greaer interger of current num
                arr[index] = nums[i];

            }
        }
        return length;
        
    }

    private int binarysearch(int[] arr , int start , int end ,  int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
}