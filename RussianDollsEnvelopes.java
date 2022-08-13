//TC - O(n * log n)
//SC - O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a,b) ->{
            if(a[1] == b[1]){
                return b[0] - a[0]; 
            }
            return a[1] - b[1];
        });
        int n = envelopes.length;
        int[] arr = new int[n];
        arr[0] = envelopes[0][0];
        int len = 1; 
        for(int i = 1; i < n; i++){
            if(envelopes[i][0] > arr[len -1]){
                arr[len] = envelopes[i][0];
                len++;
                
            }else{
                int bsIndex = binarySearch(arr, 0, len - 1, envelopes[i][0]);
                arr[bsIndex] = envelopes[i][0];
            }
           
        }
        return len;
    }
    private int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}
