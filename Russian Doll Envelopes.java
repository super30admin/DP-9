class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] arr = new int[n];//sc-O(n)

        Arrays.sort(envelopes, (a,b) ->{//weight is ascending, for same weight height is decsending
            if(a[0] == b[0]){
                return b[1] - a[1];
            }

            return a[0]-b[0];
        });

        arr[0] = envelopes[0][1];
        int len = 1;

        for(int[] envelope : envelopes){//tc- O(n)
            if(envelope[1] > arr[len-1]){
                arr[len] = envelope[1];//adding to affective sub array
                len++;
            }else{
                int bsIndex = binarySearch(arr, 0, len-1, envelope[1]);
                arr[bsIndex] = envelope[1];
            }
        }

        return len;
        
    }

        private int binarySearch(int[] arr, int low, int high, int target){//tc-O(logn)
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) high = mid -1;
            else low = mid + 1;
        }

        return low;
    }
}