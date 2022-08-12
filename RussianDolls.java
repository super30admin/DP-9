//Time: O(nlogn + logn) -> O(nlogn)
//Space: O(n)

//Binary Search Solution
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        
        //null case check
        if(n == 0 || envelopes == null) return 0;
        
        //sorting the lengths of all the enevelopes and putting the widths in decreasig order if same lengths are encountered
        //This will helpmus avoid the unnecessary increasing subsequence created if we are placing all the envelpes in creasing order of widths
        Arrays.sort(envelopes, (a,b) -> {
            if(a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
            });
        
        //in this array we will store effective subsequences and it's length at the end will give us the answer
        int [] arr = new int [n];
        
        //initializing the first element of the effective array with very first element of nums array
        arr[0] = envelopes[0][0];
        
        //we are initializing the current length of long. incr. subseq. as 1 as each single element on its own is a long. incr. subseq.
        int len = 1;
        
        //we will have an i pointer going over each element starting from the second element and 
        for(int i = 1; i < n; i++) {
            //if the width of the new envelope is larger then we place it after the current width in the effective array
            if(envelopes[i][0] > arr[len-1]) {
                arr[len] = envelopes[i][0];
                len++;
            } else { //if not then we do a binary search to find a width which we can replace with the current enverlopw width
                int bIndex = binarySearch(arr, 0, len-1, envelopes[i][0]);
                arr[bIndex] = envelopes[i][0];
            }
        }
        return len;
    }
    
  //helper binary search function
    private int binarySearch(int [] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
