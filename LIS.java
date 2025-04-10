/*
 * TC: O(n log n)
 * SC: O(n)
 */
import java.util.ArrayList;
import java.util.List;

public class LIS {
    int findIndex(List<Integer> lis, int n) {
        int left = 0;
        int right = lis.size() - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (lis.get(mid) == n) {
                return mid;
            }
            if (lis.get(mid) < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        for (int num : nums) {
            // find insertion index of nums[i] in list
            int j = findIndex(lis, num);
            // insert nums[i] at that position
            if (j >= lis.size()) lis.add(num);
            else lis.set(j, num);
        }
        // return size of list
        return lis.size();
    }
}
