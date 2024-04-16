/**
TC- O(nlogn)
SC - O(n)
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        }
        );
       int n = envelopes.length;
       int[] ar = new int[n];
       ar[0] = envelopes[0][1];
       int le =1;
       for(int i=1;i<n;i++){
        if(envelopes[i][1] > ar[le-1]){
            ar[le] = envelopes[i][1];
            le++;
        }
        else{
             int bsIndx = binarySearch(ar, 0, le-1, envelopes[i][1]);
            ar[bsIndx] = envelopes[i][1];
       } 
    }
    return le;

    }
    private int binarySearch(int[] ar,int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(target == ar[mid]){
                return mid;
            }
            else if(target>ar[mid]){
                low = mid+1;
            }
            else high = mid-1;
        }
        return low;

    }
}
