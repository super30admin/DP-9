class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[1]==b[1])
                return b[0]- a[0];
            return a[1]- b[1];
        });
    
        int n= envelopes.length;
        int arr[]= new int[n];
        // Arrays.fill(dp,1);
        int maxlen=1;
        arr[0]= envelopes[0][0];
        
        for(int i=1;i<n;i++){
            if (envelopes[i][0]> arr[maxlen-1]){
                arr[maxlen]= envelopes[i][0];
                maxlen++;
            }else{
                int bsIdx = binarySearch(arr,0,maxlen-1, envelopes[i][0]);
                arr[bsIdx]= envelopes[i][0];
            }
        }
         return maxlen;
    }
        
        private int binarySearch(int []arr, int low, int high, int target){
            while(low<=high){
                int mid= low+(high-low)/2;
                if(arr[mid]==target) return mid;
                else if(arr[mid]<target)
                    low= mid+1;
                else
                    high= mid-1;
            }
            return low;
        }
    
}
