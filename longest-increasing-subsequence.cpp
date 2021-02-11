//Time - O(nlogn)
//Space - O(n)
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        vector<int> lis(nums.size());
        lis[0] = nums[0];
        int len = 1;

        for(int i=1;i<nums.size();i++){
            if(lis[len-1]<nums[i]){
                lis[len] = nums[i];
                len++;
            }else{
                int idx = BinarySearch(lis, 0, len-1, nums[i]);
                lis[idx] = nums[i];
            }
        }
        
        return len;
    }
    
    int BinarySearch(vector<int>& lis, int l, int h, int target){
        
        
        while(l<h){
            int m = l+(h-l)/2;
            if(lis[m] == target){
                return m;
            }else if(lis[m]<target){
                l = m+1;
            }else if(lis[m]>target){
                h = m;
            }
        }
        
        return l;
    }
};