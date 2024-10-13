//TC: O(nlogn)
//SC: O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        
        // Step 1: Sort the envelopes by width and then by height (in descending order for same width)
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending order for height if widths are equal
            } else {
                return a[0] - b[0]; // Ascending order for width
            }
        });
        
        // Step 2: Extract the heights and find LIS
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }
        
        // Step 3: Apply LIS using a greedy approach with binary search
        return lengthOfLIS(heights);
    }
    
    private int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        
        for (int num : nums) {
            int i = 0, j = size;
            // Binary search to find the position to replace or extend
            while (i != j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num)
                    i = mid + 1;
                else
                    j = mid;
            }
            tails[i] = num;
            if (i == size) size++;  // Increment size if we extend the subsequence
        }
        
        return size;
    }
}
