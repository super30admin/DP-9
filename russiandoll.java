// TC : O(nlogn)
// SC : O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        
        int n = envelopes.length;
        
        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);
        
        for (int i = 1; i < n; i++) {
            if (list.get(list.size() - 1) < envelopes[i][1]) {
                list.add(envelopes[i][1]);
            } else {
                int bsIndex = binarySearch(list, envelopes[i][1]);
                list.set(bsIndex, envelopes[i][1]);
            }
        }
        return list.size();

    }

    private int binarySearch(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == list.get(mid))
                return mid;
            else if (target < list.get(mid))
                r = mid - 1;
            else
                l = mid + 1;

        }
        return l;
    }
}