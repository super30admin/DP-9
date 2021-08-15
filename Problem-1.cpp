/*
This method relies on the fact that the longest increasing subsequence possible upto the ithi^{th}ith index in a given array is independent of the elements coming later on in the array. Thus, if we know the length of the LIS upto ithi^{th}ith index, we can figure out the length of the LIS possible by including the (i+1)th(i+1)^{th}(i+1)th element based on the elements with indices jjj such that 0≤j≤(i+1)0 \leq j \leq (i + 1)0≤j≤(i+1).

We make use of a dp array to store the required data. dp[i] represents the length of the longest increasing subsequence possible considering the array elements upto the ithi^{th}ith index only ,by necessarily including the ithi^{th}ith element. In order to find out dp[i]dp[i]dp[i], we need to try to append the current element(nums[i]nums[i]nums[i]) in every possible increasing subsequences upto the (i−1)th(i-1)^{th}(i−1)th index(including the (i−1)th(i-1)^{th}(i−1)th index), such that the new sequence formed by adding the current element is also an increasing subsequence. Thus, we can easily determine dp[i]dp[i]dp[i] using:

dp[i]=max(dp[j])+1,∀0≤j<idp[i] = \text{max}(dp[j]) + 1, \forall 0\leq j < idp[i]=max(dp[j])+1,∀0≤j<i

At the end, the maximum out of all the dp[i]dp[i]dp[i]'s to determine the final result.

LISlength=max(dp[i]),∀0≤i<nLIS_{length}= \text{max}(dp[i]), \forall 0\leq i < nLISlength=max(dp[i]),∀0≤i<n
*/
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size()==0)
        {
            return 0;
        }
        vector<int> a(nums.size());
        a[0] =1;
        int ans_max = 1;
        for(int i=1;i<a.size();i++)
        {
            int ans=0;
            for (int j =0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    ans = max(ans,a[j]);
                }
            }
            a[i] = ans+1;
            ans_max = max(ans_max,a[i]);
        }
        return ans_max;
    }
};
/*
In this approach, we scan the array from left to right. We also make use of a dpdpdp array initialized with all 0's. This dpdpdp array is meant to store the increasing subsequence formed by including the currently encountered element. While traversing the numsnumsnums array, we keep on filling the dpdpdp array with the elements encountered so far. For the element corresponding to the jthj^{th}jth index (nums[j]nums[j]nums[j]), we determine its correct position in the dpdpdp array(say ithi^{th}ith index) by making use of Binary Search(which can be used since the dpdpdp array is storing increasing subsequence) and also insert it at the correct position. An important point to be noted is that for Binary Search, we consider only that portion of the dpdpdp array in which we have made the updates by inserting some elements at their correct positions(which remains always sorted). Thus, only the elements upto the ithi^{th}ith index in the dpdpdp array can determine the position of the current element in it. Since, the element enters its correct position(iii) in an ascending order in the dpdpdp array, the subsequence formed so far in it is surely an increasing subsequence. Whenever this position index iii becomes equal to the length of the LIS formed so far(lenlenlen), it means, we need to update the lenlenlen as len=len+1len = len + 1len=len+1.

Note: dpdpdp array does not result in longest increasing subsequence, but length of dpdpdp array will give you length of LIS.

Consider the example:

input: [0, 8, 4, 12, 2]

dp: [0]

dp: [0, 8]

dp: [0, 4]

dp: [0, 4, 12]

dp: [0 , 2, 12] which is not the longest increasing subsequence, but length of dpdpdp array results in length of Longest Increasing Subsequence*/
/*
int lengthOfLIS(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        vector<int> dp(nums.size()+1, INT_MAX);
        int size = 1;
        dp[0] = nums[0];
        for(int i = 1; i < nums.size(); i++) {
            int mid = lower_bound(dp.begin(), dp.begin() + size, nums[i]) - dp.begin();
            if(mid > 0)
                size = max(mid + 1, size);
            dp[mid] = min(dp[mid], nums[i]);
        }
        
        return size;
        }
*/
