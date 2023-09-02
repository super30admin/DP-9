import java.util.Scanner;
import java.util.Arrays;

public class RussianDollSortWidthLISHeightBottomUp {

        // Bottom Up Dynamic Programming - Time O(n^2) and Space O(n)
        // Sort by width, LIS on heights with distinct widths - DP

        public int maxEnvelopes(int[][] envelopes) {

            int n = envelopes.length;

            // dp array
            int[] dp = new int[n];              // O(n) space
            Arrays.fill(dp, 1);

            Arrays.sort(envelopes, (a,b) -> {    // O(nlog(n))

                // sort by ascending widths
                return a[0] - b[0];
            });

            int max = 1;

            // iterate over envelopes
            for(int i = 0; i < n; i++) {      // O(n*n)

                // compare until current envelope
                for(int j = 0; j < i; j++) {

                    // if ascending height order is maintained for distinct widths
                    if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] != envelopes[j][0]) {
                        // increase count at current envelope with count from appropriate prior envelope plus one
                        dp[i] = Math.max(dp[i], dp[j] + 1);

                        // update max length
                        max = Math.max(max, dp[i]);
                    }
                }
            }
            // output
            return max;
        }

        public static void main(String[] args) {

            RussianDollSortWidthLISHeightBottomUp obj = new RussianDollSortWidthLISHeightBottomUp();

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
Time Complexity = O(n^2) = O(n*n) + O(nlog(n))
Space Complexity = O(n)
*/