// time - O(n^2)
// space - O(n)


class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int [] dp = new int[nums.length + 1];
        Arrays.fill(dp,1);
        int max = 1;

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) { // if nums[i] > nums[j] then take the max between dp[i] & dp[j] + 1
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(dp[i],max);
                }
            }

        }

        return max;

    }
}

// time - O(nlogn)
// space - O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int [] arr = new int[nums.length];
        int len = 1;
        arr[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {

            if(nums[i] > arr[len - 1]) {  // if next element is greater then the current in thee array then add the element to the array and increease the length by one
                arr[len] = nums[i];
                len++;
            }
            else {
                int bsIndex = binarySearch(arr,0,len - 1,nums[i]); // replace nxt greater elment then the target
                arr[bsIndex] = nums[i];
            }

        }

        return len;
    }

    private int binarySearch(int [] arr, int low, int high, int target) { // find the next nearest no to the target

        while(low <= high){

            int mid = low + (high - low)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }

        }
        return low;

    }

}