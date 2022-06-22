/*
Problem: https://leetcode.com/problems/russian-doll-envelopes/
*/


// Approach 1: TLE
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        
        int n = envelopes.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        
        Arrays.sort(envelopes, (e1, e2) -> e1[0] - e2[0]);
        
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        
        return max;
    }
}

// Approach 2: Binary Search
// TC: O(n log n)
// SC: O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        
        int n = envelopes.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e2[1] - e1[1];
            } else {
                return e1[0] - e2[0];
            }
        });
        
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            if (envelopes[i][1] > sub.get(sub.size() - 1)) {
                sub.add(envelopes[i][1]);
            } else {
                int j = binarySearch(sub, envelopes[i][1]);
                sub.set(j, envelopes[i][1]);
            }
            System.out.println(sub);
        }
        
        return sub.size();
    }
    
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }
            
            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}