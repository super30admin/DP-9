//Time Complexity- O(nlogn)
//Space Complexity- O(n)

class cmp{
    public:
    bool operator()(vector<int> &a,vector<int> &b){
        
        if(a[0]==b[0]){
           return a[1]>b[1];
       }
       else{
           return a[0]<b[0];
       }
    }
};

class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        
        sort(envelopes.begin(),envelopes.end(),cmp());
        vector<int> arr(envelopes.size(),0);
        int len=1;
        arr[0]=envelopes[0][1];
        
        for(int i=1;i<envelopes.size();i++){
            if(envelopes[i][1]>arr[len-1]){
                arr[len]=envelopes[i][1];
                len++;
            }
            else{
                int idx=bs(arr,0,len-1,envelopes[i][1]);
                arr[idx]=envelopes[i][1];
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