/* Same question as largest increasing subsequence after we sort the array in ascending order with respect to first element and decending order according to the second element. i.e. after sorting we can use the second element of each subarray and find a largest increasing subsequence
TC = O(nlogn) because we used sorting also along with binary search-- better than DP solution which is O(n^2). Surprise here DP solution gives time limit exceeded
SC = O(n)
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }else{
                return a[0] - b[0];
            }
        });
        // System.out.println(Arrays.deepToString(envelopes));
        int[] effective = new int[envelopes.length];
        effective[0] = envelopes[0][1];
        int le = 1;
        for(int i=1;i<envelopes.length;i++){
            if(envelopes[i][1]>effective[le-1]){
                effective[le] = envelopes[i][1];
                le++;
            }else{
                int bsIdx = binarySearch(0,le-1,effective,envelopes[i][1]);
                effective[bsIdx] = envelopes[i][1];
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