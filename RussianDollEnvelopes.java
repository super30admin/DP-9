
/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(nlogn + nlogn)
* 
* Space Complexity: O(n)
* 
*/

import java.util.Arrays;

class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        int length = 0;

        int[] placedHeights = new int[envelopes.length];

        placedHeights[length++] = envelopes[0][1];

        for (int index = 1; index < envelopes.length; index++) {
            int envelopeHeight = envelopes[index][1];

            if (placedHeights[length - 1] < envelopeHeight) {
                placedHeights[length++] = envelopeHeight;
            } else {
                arrangeCurrHeight(placedHeights, 0, length - 1, envelopeHeight);
            }
        }

        return length;
    }

    private void arrangeCurrHeight(int[] arr, int low, int high, int target) {
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        arr[low] = target;
    }
}