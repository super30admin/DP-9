 //Time -> O(n)
 //Space -> O(n)

public class Problem2 {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            int arr[] = new int[n];
            Arrays.sort(envelopes, (a, b) ->{
                if(a[0] == b[0])
                    return b[1] - a[1];
                return a[0] - b[0];
            });
            arr[0] = envelopes[0][1];
            int le = 1; 
            for(int i = 1; i < n; i++){
                if(envelopes[i][1] > arr[le -1]){
                    arr[le] = envelopes[i][1];
                    le++;
                }
                else{
                    int bsIdx = binarySearch(arr, 0, le -1, envelopes[i][1]);
                    arr[bsIdx] = envelopes[i][1];
                }
            }
            return le;
        }
        private int binarySearch(int[] arr, int l, int h, int target){
            while(l <= h){
                int mid = l+(h-l)/2;
                if(arr[mid] == target)
                    return mid; 
                else if(arr[mid] > target)
                    h = mid - 1;
                else 
                    l = mid + 1;
            }
            return l;
        }
    }
}
