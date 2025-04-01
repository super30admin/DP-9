// TC:Onlogn
//sc:O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] arr = new int[n];
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            else return a[0]-b[0];
        });
        arr[0]=envelopes[0][1];
        int le=1;
        for(int i=1;i<n;i++){
            if(envelopes[i][1]>arr[le-1]){
                arr[le]=envelopes[i][1];
                le++;
            }else{
                int bsIndx=binarySearch(arr,0,le,envelopes[i][1]);
                arr[bsIndx]=envelopes[i][1];
            }
        }
        return le;
    }
    private int binarySearch(int[]arr, int low,int high,int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}