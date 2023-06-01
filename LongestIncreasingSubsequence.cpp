// Approach - DP
// Time Complexity -> O(n^2)
// Space Complexity -> O(n)
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> v(n, 1);
        int answer = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    v[i] = max(v[i], 1+v[j]);
                answer = max(answer, v[i]);
            }
        }
        
        return answer;
    }
};

// Approach - Maintain another array and store incoming elements in a sorted manner. 
// If the incoming elem is greater, push into the array. 
// If not, use binary Search to find the index of element that is just greater than the incoming element.
// Time Complexity -> O(n*logn)
// Space Complexity -> O(n)
class Solution {
    int bSearch(vector<int>& v, int k){
        int n = v.size();
        int low = 0;
        int high = n-1;
        int mid;
        
        while(low <= high){
            mid = low + (high - low)/2;
            
            if(v[mid] == k)
                return mid;
            else if(v[mid] < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return low;
    }
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> v;
        v.push_back(nums[0]);
        
        for(int i = 1; i < n; i++){
            if(nums[i] < v.back()){
                // replace the elem in v that is just greater than nums[i]
                int idxReplace = bSearch(v, nums[i]);
                v[idxReplace] = nums[i];
            }
            else if(nums[i] > v.back())
                v.push_back(nums[i]);
            else
                continue;
        }
        
        return v.size();
    }
};