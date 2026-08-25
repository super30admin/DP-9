/**
 * Time Complexity:  O(nlogn)  where n is the length of the array
 * Space Complexity: O(n) where n is the length of the array
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int n = envelopes.length;
        List<Integer> result = new ArrayList<>();
        result.add(envelopes[0][1]);

        for(int i=1; i<n; i++){
            if(envelopes[i][1] > result.get(result.size()-1)){
                result.add(envelopes[i][1]);
            }else{
                int index = findTheSmallestNumberGreaterThanCurrentNumber(envelopes, result, i);
                result.set(index, envelopes[i][1]);
            }
        }

        return result.size();
    }

    int findTheSmallestNumberGreaterThanCurrentNumber(int[][] envelopes, List<Integer> result, int i) {
        int num = envelopes[i][1];

        int left = 0;
        int right = result.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (num == result.get(mid)) {
                return mid;
            } else if (num > result.get(mid)) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}