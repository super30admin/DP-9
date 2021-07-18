// Time complexity-O(nlogn)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

//  create an effective array to store a supposed version of the largest subsequence
// try to find the lower bound of that element which is just greater than the incomimg element
// replace the greater element with the incoming element in the resultant array
// the resultant array doesnt contain the actual LIS but its length is correct. 



/***********************************************binary search************************************************************/
class Solution {
public:
    
    int binary_search(vector<int> &arr,int low,int high,int target){
        
        while(low <=high){
              int mid= low + (high-low)/2;

            if(arr[mid]== target){return mid;}
            else if(arr[mid] > target){
                high = mid -1;

            }
            else{
                low = mid + 1;

            }
            
        }
        return low;
    }
    int lengthOfLIS(vector<int>& nums) {
        if( nums.size()==0 ){return 0;}
        vector<int>arr(nums.size(),0);// effective subsequence array
        int len =1;
        arr[0]= nums[0];
        
        
        for(int i=1;i<arr.size();i++){
            if(nums[i]> arr[len-1] ){
                arr[len]= nums[i];
                len++;
            }
            else{
                int bsIndex= binary_search(arr,0,len-1,nums[i]);
                arr[bsIndex]= nums[i];
            }
        }
        return len;
    }
};



/**********************************************************************************************************************/


/************************************************************************************dynamic programming*************************************/
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if( nums.size()==0 ){return 0;}
        vector<int>dp(nums.size(),1);
        int maxim=1;
        
        for(int i=1;i<dp.size();i++){
            for(int j=0;j<i;j++){
                if(nums[j]< nums[i]){
                    dp[i]= max(dp[i],dp[j]+1);
                }
            }
            maxim=max(maxim,dp[i]);
        }
        return maxim;
    }
};
/*********************************************************dynamic programming**************************************************/