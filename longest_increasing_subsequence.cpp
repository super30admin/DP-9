// Time Complexity : O(n2)
// Space Complexity : O(n2)
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//1. Construct dp array. Approach it as power set problem.
//2. Fix upperbound. Go through each element from starting till upperbound and update when a sequence can be formed.
//3. Store the max_count simultaneously


class Solution {
public:
    
    int lengthOfLIS(vector<int>& nums) {
        //edge
        if(nums.size()==0)
            return 0;
        
        //logic
        int size =  nums.size();
        //Explored individual element subset
        vector<vector<int>> list(size);
        vector<int> dp(size,1); 
        int max_count =1;
        //initially push self in result list
        for(int i=0; i<size; i++){
            list[i].push_back(nums[i]);
        }
        
        for(int i=1; i<size; i++){
           for(int j=0; j<i; j++){
              if(nums[i] > nums[j])
                  dp[i] = max(dp[i], dp[j]+1);
               
               if(max_count<dp[i]){
                   max_count =dp[i];
                   list[i] = list[j];
                   list[i].push_back(nums[i]);
               }
                   
            }
        }
        
        for(int i=0; i<size; i++){
            if(max_count == dp[i]){
                for(int j=0; j<list[i].size(); j++){
                    cout<<list[i][j]<<"\t";
                }
                cout<<endl;
                break;
            }
        }
        return max_count;
    }
};


// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Any problem you faced while coding this :
//Understand where to replace the new incoming element

// Your code here along with comments explaining your approach
//1. Construct effective array. Add element when its greater than the last element. Replace it with closest largest element if less than the largest element.
//2. Go through the array once.
//3. Return the length. effective_aaray will not give the array sequence.


class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        //edge
        if(nums.size()==0)
            return 0;
        
        //logic
        int size =  nums.size();
        //Explored individual element subset
        vector<int> eff_array;
        eff_array.push_back(nums[0]);
        int len =0;
        for(int j =1; j<size; j++){
                if(eff_array[len] > nums[j]){
                    int idx = bin_search(eff_array, 0, len-1, nums[j]);
                    eff_array[idx] = nums[j];
                }else if(eff_array[len] < nums[j]){
                    eff_array.push_back(nums[j]);
                    len++;
                }
        }
        return eff_array.size();
    }
    
    int bin_search(vector<int>& eff_array, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(eff_array[mid] ==target){
                return mid;
            }else if(eff_array[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
};
