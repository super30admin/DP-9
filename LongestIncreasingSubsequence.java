package s30.dp.dp9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Memoisation
//Algo: We need to try for multiple combinations of elements from the array.
// skip and not skip an element and fins the maxLIS from that position with the prev reference.
//TC: O(n^2);
//SC: O(n^2);



//Bottom Up Approach.
//Algo: Take a dp array, iterate back in the given array and fill the dp array with decision.
//TC: O(n^2);
//SC: O(n);


//nlogn approach
//Algo: take a new array and insert the elements in ascending order, if you encounter a smaller element in future
//find the insert position in the new sorted array and replace it, so that future LIS with that number will not be lost
//and existing will not be loosen because we are replacing that particular position from which our array size is being maintained.

//TC: O(nlogn);
//SC: O(n);
public class LongestIncreasingSubsequence {


    int[][] dp;


    //O(nlogn) soln
    public int lengthOfLISEff(int[] nums) {

        List<Integer> seq = new ArrayList();

        for(int i = 0; i < nums.length; i++ ){

            if(i==0 || seq.get(seq.size()-1) < nums[i]){
                seq.add(nums[i]);
            }
            else{

                int index = binarySearch(seq, nums[i]);

                seq.set(index, nums[i]);
            }
        }

        return seq.size();

    }


    private int binarySearch(List<Integer> seq, int num){
        int start =0, end = seq.size()-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(seq.get(mid) == num) return mid;
            else if(num > seq.get(mid)){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }

        return start;
    }


    public int lengthOfLISBottomUp(int[] nums) {

        int ans = -1;

        int[] dp = new int[nums.length];

        for(int i=0; i < nums.length; i++){

            dp[i]=1;

            for(int j=0; j < i; j++){

                if(nums[j] < nums[i]){

                    dp[i] = Math.max(
                            dp[i],
                            1+ dp[j]
                    );
                }

            }

            ans = Math.max(ans, dp[i]);

        }


        return ans;
    }



    public int lengthOfLIS(int[] nums) {

        dp = new int[nums.length+1][nums.length+1];

        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return lengthOfLIS(nums, 0, 1);

    }

    private int lengthOfLIS(int[] nums, int prev, int curr){
        //base
        if(curr == nums.length+1){
            return 0;
        }


        //recurse

        if(dp[prev][curr] == -1){

            int prevEle = prev == 0 ? Integer.MIN_VALUE : nums[prev-1];
            int currEle = nums[curr - 1];

            int select =0;
            if(currEle > prevEle){
                select = 1 + lengthOfLIS(nums, curr, curr+1);
            }

            int notSelect = lengthOfLIS(nums, prev, curr+1);

            dp[prev][curr] = Math.max(select, notSelect);
        }

        return dp[prev][curr];
    }


    public static void main(String[] args) {

    }
}
