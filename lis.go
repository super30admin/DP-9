// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create arr and set first element to nums[0] set length to 1
loop over nums starting at 1
if nums[1] >last element of arr then append it to arr and increment length
else find minimum index bigger than nums value and replace it

return length
*/
package main

import "fmt"

func lengthOfLIS(nums []int) int {
	//n2 solution
	/*dp := make([]int, len(nums))
	  for i:=0;i<len(dp);i++ {
	      dp[i] = 1
	  }
	  max:=1
	  for i:=1;i<len(nums);i++ {
	      for j:=0;j<i;j++ {
	          if nums[j]<nums[i] {
	              dp[i] = fmax(dp[j]+1, dp[i])
	          }
	      }
	      max = fmax(max, dp[i])
	  }
	  return max*/

	//binary search solution
	arr := make([]int, len(nums))
	length := 0
	arr[0] = nums[0]
	length++
	for i := 1; i < len(nums); i++ {
		if nums[i] > arr[length-1] {
			arr[length] = nums[i]
			length++
		} else {
			ind := binSearch(arr, 0, length-1, nums[i])
			arr[ind] = nums[i]
		}
	}
	return length
}

func binSearch(nums []int, low, high, target int) int {
	for low <= high {
		mid := low + (high-low)/2
		if nums[mid] == target {
			return mid
		} else if nums[mid] > target {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return low
}

func fmax(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func MainLengthOfList() {
	fmt.Println(lengthOfLIS([]int{10, 9, 2, 5, 3, 7, 101, 18})) //expected 4
}
