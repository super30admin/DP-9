class Solution {
    private int upperBound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target)
                return mid;
            else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        // dp
        int n = nums.length;
        int[] dp = new int[n];
        int res = 1;
        ArrayList<Integer>list=new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }
            else{
                int replaceIdx=upperBound(list,nums[i]);
                list.set(replaceIdx,nums[i]);
            }

        }
        return list.size();
    }
}
