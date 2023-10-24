// Time Complexity : O(nlogn)
// Space Complexity : O(n)

// Approach:
// 1. Sort the input array based on the width of the envelopes in ascending order. If the width of two envelopes are same, then sort them based on the height in descending order.
// 2. Create an array of size n and initialize the first element with the first element of the input array.
// 3. Iterate over the input array from index 1 to n-1.
// 4. If the current element is greater than the last element of the effective array, then append the current element to the effective array and increment len.
// 5. Else, do a binary search on the effective array and find the index of the first element that is greater than the current element. Replace the element at that index with the current element.
// 6. Return len.

import java.util.Arrays;

public class RussianDollEnvelopes {
        public static void main(String[] args) {
            int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
            RussianDollEnvelopes rde = new RussianDollEnvelopes();
            System.out.println(rde.maxEnvelopes(envelopes));
        }
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
