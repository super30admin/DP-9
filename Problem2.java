//O(NlogN) time
//O(N) space

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->a[0] == b[0]?b[1] - a[1]:a[0]-b[0]);

        int arr[]= new int[envelopes.length];
        int arr2[] = new int[envelopes.length];
        int index = 0;

        arr[index] = envelopes[index][1];
        arr2[index] = envelopes[index][0];
        int temp;
        for(int i = 1; i<envelopes.length;i++){
            if(envelopes[i][1] > arr[index] && envelopes[i][0] > arr2[index]){
                arr[++index] = envelopes[i][1];
                arr2[index] = envelopes[i][0];
            }
            else{
                temp = bs(arr, index, envelopes[i][1]);
                arr[temp] = envelopes[i][1];
                arr2[temp] = envelopes[i][0];
            }
        }

        return index + 1;

    }

    private int bs(int arr[], int high, int target){
        int low = 0;
        int mid;

        while(low<high){
            mid = low + (high - low)/2;

            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}