// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem2 {
    public int maxEnvelopes(int[][] envelopes) {

        //sort width by ascending order and sort width by descending;
        Arrays.sort(envelopes,(a,b)->{
            if(a[0] != b[0]){
                return  a[0] - b[0];
            }else{
                return b[1] - a[1];
            }
        });


        return lisHelper(envelopes);


    }
    //TC : O(NlogN)
    int lisHelper(int[][] envelopes){
        int n = envelopes.length;
        int [] arr = new int[n];
        Arrays.fill(arr,Integer.MIN_VALUE);
        arr[0]=envelopes[0][1] ;//find LIS on width

        int len = 1;
        for(int i=1;i<n;i++){
            if(envelopes[i][1] > arr[len-1]){
                //add to the array and move forward
                arr[len] =  envelopes[i][1];
                len++;
            }else{
                //find the equal or next greater element and replace it with the incoming number
                int idx =  binraySearch(arr,0,len-1,envelopes[i][1]);
                arr[idx]= envelopes[i][1];
            }
        }

        return len;
    }
    //TC:O(Logn)
    int binraySearch(int[] arr,int l , int h,int target){
        while(l<=h){
            int mid = l+ (h-l)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid]<target){
                l = mid +1;
            }else{
                h = mid - 1;
            }
        }
        return l;
    }
}
