import java.util.Arrays;

public class RussianDollEnvelopes {

    // TC: O(N log N) where N is length of nums
    // SC: O(N) where N is length of nums
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        int res = 1;
        int n = envelopes.length;
        int[] sequence = new int[n];
        sequence[0] = envelopes[0][0];
        int sequenceIndex = 1;
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > sequence[sequenceIndex - 1]) {
                sequence[sequenceIndex] = envelopes[i][1];
                sequenceIndex++;
            } else {
                int indexToReplace = findIndexToReplace(sequence, 0, sequenceIndex - 1, envelopes[i][1]);
                sequence[indexToReplace] = envelopes[i][1];
            }
            res = Math.max(res, sequenceIndex);
        }
        return res;
    }

    private int findIndexToReplace(int[] sequence, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sequence[mid] == target) {
                return mid;
            } else if (sequence[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
