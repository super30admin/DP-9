//354. Russian Doll Envelopes - https://leetcode.com/problems/russian-doll-envelopes/description/
//Time Complexity: O(n*log(n))
//Space Complexity: O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //sort the array (w,h)
        Arrays.sort(envelopes, (a,b)->{
            if(a[0]==b[0]) {
                //if widths are same, sort heights in desc order
                return b[1]-a[1];
            }else {
                //if widths are not same, sort widths in asc order
                return a[0]-b[0];
            }
        });
        int len=1; //max no. of envelopes we can russian doll
        int n = envelopes.length;
        int[] arr = new int[n];
        arr[0] = envelopes[0][1]; //w,h -> [0][1]

        for(int i=1; i<n; i++){
            //incoming element is > last element
            if(envelopes[i][1] > arr[len-1]){
                arr[len] = envelopes[i][1];//append it to end of len
                len++;
            } else{
                int bsIndex = binarySearch(arr, 0, len-1, envelopes[i][1]);
                arr[bsIndex] = envelopes[i][1];
            }
        }
        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid= low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > target){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return low;
    }
}