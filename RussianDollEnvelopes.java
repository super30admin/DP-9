import java.util.Arrays;

//Time Complexity : O(n log n) 
//Space Complexity : O(n)
public class RussianDollEnvelopes { 	
	/**Approach: Binary Search**/
	public int maxEnvelopes(int[][] envelopes) {
		//Sort on the height then sort width in decreasing order
        Arrays.sort(envelopes, (a,b)->{ 
            if(a[1] == b[1]) return b[0]-a[0];
            return a[1]-b[1];
        });
        
        int n= envelopes.length;        
        int[] arr = new int[n];
        arr[0] = envelopes[0][0]; 
        int len = 1;
        for(int i=1; i<n; i++){
             if(envelopes[i][0] > arr[len-1]){
                arr[len] = envelopes[i][0];
                len++;
            }else{
                //replace number to just higher element in effective array
                int index = binarySearch(arr, 0, len-1, envelopes[i][0]);
                arr[index] = envelopes[i][0];
            }
        }
        return len;
    }    
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid= low + (high-low) / 2;
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return low;
    }
    
	// Driver code to test above
	public static void main (String[] args) {	
		RussianDollEnvelopes ob  = new RussianDollEnvelopes();			
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println("Maximum number of envelopes we can Russian doll: "+ob.maxEnvelopes(envelopes));
	}
}
