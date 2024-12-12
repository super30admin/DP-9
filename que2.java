class Solution {
    // Helper method to find the upper bound index for the target in the sorted list
    private int upperBound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int res = 0;
        // Binary search to find the first element greater than the target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) return mid;  // Exact match found
            else if (list.get(mid) < target) {
                left = mid + 1;  // Search in the right half
            } else {
                res = mid;  // Potential position found
                right = mid - 1;  // Search in the left half
            }
        }
        return res;
    }

    public int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes by width; if equal, sort by height in descending order
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            else {
                return a[0] - b[0];
            }
        });

        // List to store the increasing sequence of heights
        ArrayList<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);  // Start with the first envelope's height

        // Process each envelope's height
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > list.get(list.size() - 1)) {
                // If current height is greater than the last in the list, append it
                list.add(envelopes[i][1]);
            } else {
                // Find the index to replace the height to maintain the sorted order
                int replaceIdx = upperBound(list, envelopes[i][1]);
                list.set(replaceIdx, envelopes[i][1]);  // Replace to maintain increasing sequence
            }
        }
        // The size of the list is the length of the longest increasing subsequence
        return list.size();
    }
}
