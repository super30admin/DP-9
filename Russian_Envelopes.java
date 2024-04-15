//TimeComplexity:O(nlogn)
//spacecomplexity:O(n)

class Solution {
    int binarySearch(int []effectiveArray, int low, int high, int target) {
        while(low<=high) {
            int mid = low +(high-low)/2;
            if(effectiveArray[mid] == target) {
                return mid;
            } else if(effectiveArray[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
            
        }
        return low;
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)-> {
            if(a[0] == b[0]) {
                return b[1]-a[1];
            }

            return a[0]-b[0];
        });

        int []effectiveArray = new int[envelopes.length];
        effectiveArray[0] = envelopes[0][1];
        int lastElement = 0;
        for(int i =1; i<envelopes.length;i++) {
            if(envelopes[i][1]> effectiveArray[lastElement]) {
                lastElement++;
              effectiveArray[lastElement] = envelopes[i][1];
              
              
            } else {
                int index = binarySearch(effectiveArray, 0, lastElement-1, envelopes[i][1]);
                effectiveArray[index] = envelopes[i][1];
                
            }
        }
   return lastElement+1;
        }
    }
