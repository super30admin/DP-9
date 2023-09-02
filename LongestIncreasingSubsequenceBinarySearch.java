import java.util.Scanner;

public class LongestIncreasingSubsequenceBinarySearch {

        // DP can give length and actual longest increasing subsequence with help of hashmap or other auxiliary DS to store
        // Binary Search algorithm can only give the length of LIS , but not the actual LIS itself

        // Smaller element in nums (than the last of LIS) replacing just larger than itself in LIS array
        // with Binary Search - Time O(nlog(n))and Space O(n)
        // This replacement increases probability of getting a longer increasing subsequence further

        public int lengthOfLIS(int[] nums) {

            int n = nums.length;

            // create and initiate LIS array
            int[] arrLIS = new int[n];       // O(n) space
            arrLIS[0] = nums[0];

            // last pointer of LIS array
            int last = 0;

            // iterate over nums
            for(int i = 1; i < n; i++) {       // O(n)

                // if nums element is greater than the last element in LIS
                if(nums[i] > arrLIS[last]) {

                    // just add it to LIS
                    arrLIS[last+1] = nums[i];

                    // update last pointer after addition of larger element in LIS
                    last++;
                }

                // if nums element is smaller than the last element in LIS, replace it with a just greater element in LIS which can be found through binary search
                else {

                    // make replacement which increases probability of getting a longer increasing subsequence further
                    int idxReplace = binarySearch(arrLIS, 0, last, nums[i]);  // O(logn)
                    arrLIS[idxReplace] = nums[i];

                    // length of LIS array remains the same during replacement
                }
            }

            // length is one greater than the last index of LIS
            return last + 1;
        }

        public int binarySearch(int[] arrLIS, int l, int r, int replaceFor) {

            // invariant
            while(l <= r) {

                // mid
                int mid = l + (r-l)/2;

                if(arrLIS[mid] == replaceFor) {
                    //
                    return mid;
                }

                // if mid is greater, bring search to the left half
                else if(arrLIS[mid] > replaceFor) {
                    //
                    r = mid - 1;
                }

                // if mid is smaller, bring search to the right half
                else {
                    //
                    l = mid + 1;
                }
            }
            // return to lengthOfLIS method
            return l;
        }

        public static void main(String[] args) {

            LongestIncreasingSubsequenceBinarySearch obj = new LongestIncreasingSubsequenceBinarySearch();

            Scanner scanner = new Scanner(System.in);

            System.out.println("length of nums: ");
            int n = scanner.nextInt();
            int[] nums = new int[n];

            System.out.println("nums: ");
            for(int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            int answer = obj.lengthOfLIS(nums);

            System.out.println("the length of the longest strictly increasing subsequence: " + answer);
        }

}


/*
Time Complexity = O(nlog(n))
Space Complexity = O(n)
*/