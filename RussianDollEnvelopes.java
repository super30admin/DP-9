class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes , (a , b) -> {
            if(a[0] == b[0]){
                //if widths are same , sort based on dec order of heights
                return b[1] - a[1];
            }
            else{ //if widths are different , inc order of widths
                return a[0] - b[0];
            }

        });
        
        int[] arr = new int[n];
        arr[0] = envelopes[0][1];
        int length = 1;
        for(int i = 1 ; i < n ; i++){
            if(envelopes[i][1] > arr[length - 1]){
                arr[length] = envelopes[i][1];
                length ++;
            }
            else{
                int index = binarysearch(arr , 0 , length , envelopes[i][1]);
                arr[index] = envelopes[i][1];
            }
        }
        return length;

        
    }

    private int binarysearch(int[] arr , int start , int end , int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else {
                start = mid+1;
            }
        }
        return start;

    }
}