import java.util.Scanner;
import java.util.Arrays;

public class RussianDollSortAscHeightDscWidthReplaceLISWidthArrBinarySearch {

    // Replacement and Binary Search - Time O(nlog(n)) and Space O(n)
    // Sort by increasing heights with decreasing widths, LIS on widths

    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;

        // LIS array on widths
        int[] arrLIS = new int[n];              // O(n) space

        // custom sort
        // decreasing width sorting ensures widths with same height do not go into LIS array
        Arrays.sort(envelopes, (a,b) -> {    // O(nlog(n))

            // if same height, sort by descending widths
            if(a[1] == b[1]) {

                //
                return b[0] - a[0];
            }
            // sort by ascending heights
            return a[1] - b[1];
        });

        // initialize LIS
        arrLIS[0] = envelopes[0][0];

        // last LIS pointer
        int last = 1;

        // iterate over envelopes
        for(int[] envelope: envelopes) {      // O(n)

            // if envelope width is greater than last available width in LIS array
            if(envelope[0] > arrLIS[last-1]) {

                // add envelope width to LIS array
                arrLIS[last] = envelope[0];

                // move last LIS pointer
                last++;
            }

            // if envelope width is smaller than last available width in LIS array
            else {

                // find just greater than envelope width in LIS array through binary search for replacement
                int idxGreater =  binarySearch(arrLIS, 0, last-1, envelope[0]);
                // O(log(n))

                // replace LIS array
                arrLIS[idxGreater] = envelope[0];
            }
        }

        // output
        return last;
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

            RussianDollSortAscHeightDscWidthReplaceLISWidthArrBinarySearch obj =
                    new RussianDollSortAscHeightDscWidthReplaceLISWidthArrBinarySearch();

            Scanner scanner = new Scanner(System.in);

            System.out.println("number of envelopes: ");
            int n = scanner.nextInt();

            int[][] envelopes = new int[n][2];

            for(int i = 0; i < n; i++) {

                System.out.println("envelope: " + (i+1));
                envelopes[i][0] = scanner.nextInt();
                envelopes[i][1] = scanner.nextInt();
            }

            int answer = obj.maxEnvelopes(envelopes);
            System.out.println("the maximum number of envelopes we can Russian doll " +
                    "(i.e., put one inside the other): " + answer);

    }

}

/*
Time Complexity =  O(nlog(n))
Space Complexity = O(n)
*/