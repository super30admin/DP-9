class Solution {
    
    //Binary-seach approach
    //Time Complexity: O(n*log(n))
    //Space Complexity: O(n)

    public int lengthOfLIS(int[] nums) {
     
        List<Integer> sequence = new ArrayList<>();                         //create a sequence list to store the effective longest subsequence
        sequence.add(nums[0]);                                              //add the nums[0] into list
        
        for(int i=1; i<nums.length; i++){                                   //iterate through nums
            
            int num = nums[i];                                              
            
            if(num > sequence.get(sequence.size() - 1)){                    //check if the current num is greater than the last number in the sequence
                sequence.add(num);                                          //if so, then add it to the sequence
            }
            else{
                int sortedIndex = getSortedIndex(sequence, num);            //if not, then call the getSortedIndex function, if incoming element is not greater than the last added number, then we just simply find the position which is just greater than the current num value, and add the current num to that position, the reason behind replacing the old number to the current num is that, current num might get us a longest increasing subsequence in the future 
                sequence.set(sortedIndex, num);                             //set the currentNum on sortedIndex
            }    
        }   
        return sequence.size();                                             //return the size of the sequence
    }
    
    public int getSortedIndex(List<Integer> list, int target){
        
        int start = 0;                                                      //start pointer 
        int end = list.size() - 1;                                          //end pointer
        
        while(start<=end){                                                  //iterate till start <= end
            
            int mid = start + (end-start)/2;                                //calculate the mid pointer value
            int midEle = list.get(mid);                                     //get the element value for mid pointer from list
            
            if(midEle == target){                                           //check if midEle is equal to target 
                return mid;                                                 //if it equals, then return mid
            }
            
            if(target < midEle){                                            //check if target < midEle
                end = mid - 1;                                              //if yes then, update end pointer to mid-1
            }
            else{                                                           //means target > midEle
                start = mid + 1;                                            //then update the start pointer to mid+1
            }
        }
        return start;                                                       //return the start pointer
    }


//     //Bottom up approach, starting from 0, you can start from end as well
//     //Time Complexity: O(n*n)
//     //Space Complexity: O(n)

//     public int lengthOfLIS(int[] nums) {
       
//         int[] dp = new int[nums.length];                    //initilaize the dp array
//         int ans = 1;                                        //declare the ans variable
        
//         for(int i=0; i<nums.length; i++){                   //iterating from the nums array
            
//             dp[i] = 1;                                      //each element is also subsequence, so initialize the dp[i] =1
            
//             for(int j=0; j<i; j++){                         //iterating from the 0th index to i index
                
//                 if(nums[j] < nums[i]){                      //check if any element is less than the currentIndex
                    
//                     dp[i] = Math.max(dp[i], 1 + dp[j]);    //if it's lesser then currentElement, then reinitialize the dp[i] to max of dp[i] and 1+ dp[j]
                
//                 }
//             }
//             ans = Math.max(ans, dp[i]);                     //maintain the max of all nums element
//         }
//         return ans;
//     }
    
    
    
    
    //Memoization Approch 2, Top Down Approach, 0 based Indexing, taking prevIndex
    //Time Complexity: O(n*n), n is nums length
    //Space Complexity: O(n*n)
    
//     int[][] dp;
//     public int lengthOfLIS(int[] nums) {
       
//         dp = new int[nums.length+1][nums.length];
        
//         for(int i=0; i<dp.length; i++){
//             Arrays.fill(dp[i], -1);
//         }
        
//         return lengthOfLIS(nums, 0, -1);
        
//     }
    
//     public int lengthOfLIS(int[] nums, int currentIndex, int prevIndex){
        
    
//         //base
//         if(currentIndex == nums.length){
//             return 0;
//         }
        
        
//         if(dp[currentIndex][prevIndex+1] == -1){
        
//             //notSelect
//             int ans = lengthOfLIS(nums, currentIndex+1, prevIndex);


//             //select
//             int currentEle = nums[currentIndex];
//             int prevEle = prevIndex == -1 ? Integer.MIN_VALUE : nums[prevIndex];

//             if(currentEle > prevEle){

//                 ans = Math.max(ans, 1 + lengthOfLIS(nums, currentIndex+1, currentIndex));

//             }
//             dp[currentIndex][prevIndex+1] = ans;  
//         }
//         return dp[currentIndex][prevIndex+1];
//     }
    
    
    //Memoization Approch 1, Top Down Approach, 1 based Indexing, taking prevIndex
    //Time Complexity: O(n*n), n is nums length
    //Space Complexity: O(n*n)
    
//     int[][] dp;
//     public int lengthOfLIS(int[] nums) {
       
//         dp = new int[nums.length+1][nums.length];
        
//         for(int i=0; i<dp.length; i++){
//             Arrays.fill(dp[i], -1);
//         }
        
//         return lengthOfLIS(nums, 1, 0);
        
//     }
    
//     public int lengthOfLIS(int[] nums, int currentIndex, int prevIndex){
        
//         //base
//         if(currentIndex == nums.length+1){
//             return 0;
//         }
        
        
//         if(dp[currentIndex][prevIndex] == -1){
        
//             //notSelect
//             int ans = lengthOfLIS(nums, currentIndex+1, prevIndex);


//             //select
//             int currentEle = nums[currentIndex-1];
//             int prevEle = prevIndex == 0 ? Integer.MIN_VALUE : nums[prevIndex-1];

//             if(currentEle > prevEle){

//                 ans = Math.max(ans, 1 + lengthOfLIS(nums, currentIndex+1, currentIndex));

//             }
//             dp[currentIndex][prevIndex] = ans;
            
//         }
        
//         return dp[currentIndex][prevIndex];
    
//     }
    
    
    
    
    
    //Recursive Approch 1, Zero based Indexing, taking prevEle, time limit Exceed error
    //Time Complexity: O(2^n), n is nums length
    //Space Complexity: O(n)
    
//     public int lengthOfLIS(int[] nums) {
        
//         return lengthOfLIS(nums, 0, Integer.MIN_VALUE);
//     }
    
//     public int lengthOfLIS(int[] nums, int currentIndex, int prevEle){
        
//         //base
//         if(currentIndex == nums.length){
//             return 0;
//         }
        
//         //notSelect
//         int ans = lengthOfLIS(nums, currentIndex+1, prevEle);
        
//         //select
//         int currentEle = nums[currentIndex];
//         if(currentEle > prevEle){
            
//             ans = Math.max(ans, 1 + lengthOfLIS(nums, currentIndex+1, currentEle));
//         }
//         return ans;
//     }
    
    
    
    
     //Recursive Approch 2, Zero based Indexing, taking prevIndex,  time limit Exceed error
    //Time Complexity: O(2^n), n is nums length
    //Space Complexity: O(n)
    
//     public int lengthOfLIS(int[] nums) {
        
//         return lengthOfLIS(nums, 0, -1);
//     }
    
//     public int lengthOfLIS(int[] nums, int currentIndex, int prevIndex){
        
//         //base
//         if(currentIndex == nums.length){
//             return 0;
//         }
        
//         //notSelect
//         int ans = lengthOfLIS(nums, currentIndex+1, prevIndex);
        
//         //select
//         int currentEle = nums[currentIndex];
//         int prevEle = prevIndex == -1 ? Integer.MIN_VALUE : nums[prevIndex];
        
//         if(currentEle > prevEle){
//             ans = Math.max(ans, 1 + lengthOfLIS(nums, currentIndex+1, currentIndex));
//         }
//         return ans;
//     }
    
    
    //Recursive Approch 3, 1 based Indexing, taking prevIndex,  time limit Exceed error
    //Time Complexity: O(2^n), n is nums length
    //Space Complexity: O(n)
    
//     public int lengthOfLIS(int[] nums) {
        
//         return lengthOfLIS(nums, 1, 0);
//     }
    
//     public int lengthOfLIS(int[] nums, int currentIndex, int prevIndex){
        
//         //base
//         if(currentIndex == nums.length+1){
//             return 0;
//         }
        
//         //notSelect
//         int ans = lengthOfLIS(nums, currentIndex+1, prevIndex);
        
//         //select
//         int currentEle = nums[currentIndex-1];
//         int prevEle = prevIndex == 0 ? Integer.MIN_VALUE : nums[prevIndex-1];
        
//         if(currentEle > prevEle){
//             ans = Math.max(ans, 1 + lengthOfLIS(nums, currentIndex+1, currentIndex));
//         }
//         return ans;
//     }
 }
