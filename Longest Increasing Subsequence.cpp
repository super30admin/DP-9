//Time Complexity- O(nlogn)
//Space Complexity- O(n)

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        
        vector<int> arr(nums.size(),0);
        int len=1;
        arr[0]=nums[0];
        
        for(int i=1;i<nums.size();i++){
            if(nums[i]>arr[len-1]){
                arr[len]=nums[i];
                len++;
            }
            else{
                int idx=bs(arr,0,len-1,nums[i]);
                arr[idx]=nums[i];
            }
        }
        return len;
    }
    
    int bs(vector<int> &arr,int start,int end,int val){
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==val){
                return mid;
            }
            else if(arr[mid]<val){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
};