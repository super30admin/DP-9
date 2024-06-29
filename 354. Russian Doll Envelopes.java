// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Method used : LIS

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // Sort array on basis of width and if both pairs are of same width sort them according to decreasing heights

        Arrays.sort(envelopes, (a, b) -> {

            // Sort according to heights
            if(a[0] == b[0]) return b[1] - a[1];

            return a[0] - b[0];
        });

        // Apply LIS to height elements
        int n = envelopes.length;
        int[] height_array = new int[n];

        for(int i = 0; i < n; i++) height_array[i] = envelopes[i][1];

        System.out.println(Arrays.toString(height_array));

        List<Integer> result = new ArrayList();
        result.add(height_array[0]);

        for(int i = 1; i < n; i++)
        {
            if(height_array[i] > result.get(result.size() - 1)) result.add(height_array[i]);

            else
            {
                binarySearch(result, 0, result.size() - 1, height_array[i]);
            }
        }

        return result.size();

    }

    private void binarySearch(List<Integer> result, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(target == result.get(mid)) return;

            if(target < result.get(mid)) high = mid - 1;

            else low = mid + 1;
        }

        // replace the target element with element at low index
        result.set(low, target);
    }
}
