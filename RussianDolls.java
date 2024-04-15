// TC: O(nlogn)
// SC: O(n)

// Approach: Sort based on heights first and then descending order of widths.
// This ensures that dolls of same heights can not form a sequence as their widths
// are in descending order. Maintain effective longest increasing subsequence and
// return the size of the list.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RussianDolls {
    public int maxEnvelopes(int[][] envelopes) {
        List<Integer> list = new ArrayList<>();
        int[] widthArr = new int[envelopes.length];

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] - b[0] == 0) {
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        int k = 0;
        for (int[] envelope : envelopes) {
            widthArr[k] = envelope[1];
            k++;
        }

        list.add(widthArr[0]);

        for (int i = 1; i < widthArr.length; i++) {
            if (widthArr[i] > list.get(list.size() - 1)) {
                list.add(widthArr[i]);
            } else {
                int index = binarySearch(list, widthArr[i]);
                list.set(index, widthArr[i]);
            }
        }

        return list.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int end = list.size() - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (list.get(mid) == target) {
                return mid;
            }

            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}