class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
        if (n == 0) return 0;

        int[] seq = new int[n];
        seq[0] = nums[0];
        int idx = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > seq[idx]) {
                seq[++idx] = nums[i];
            } else {
                int pos = binarysearch(seq, 0, idx, nums[i]);
                seq[pos] = nums[i];
            }
        }

        return idx + 1;
    }

    private int binarysearch(int[] seq, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (seq[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

//tc: O(nlogn)
//sc: O(n)
