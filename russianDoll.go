// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
sort envelopes by ascending width and descending height
rest of the problem is lis

return length
*/
package main

import (
	"fmt"
	"sort"
)

func maxEnvelopes(envelopes [][]int) int {
	/*if len(envelopes) == 0 {
	      return 0
	  }
	  //sort by one column
	  sort.SliceStable(envelopes, func(i, j int) bool {
	      return envelopes[i][0] < envelopes[j][0]
	  })
	  fmt.Println(envelopes)

	  //becomes longest increasing subseqence problem on the other index
	  dp := make([]int, len(envelopes))
	  for i:=0;i<len(dp);i++ {
	      dp[i] = 1
	  }

	  max := 1
	  for i:=1;i<len(envelopes);i++ {
	      for j:=0;j<i;j++ {
	          if envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0] {
	              dp[i] = fmax(dp[j]+1, dp[i])
	              max = fmax(max, dp[i])
	          }
	      }
	  }

	  return max*/

	//binary search solution
	// sort asending by width and descending by height
	// to convert the question into find LIS
	sort.Slice(envelopes, func(i, j int) bool {
		if envelopes[i][0] == envelopes[j][0] {
			return envelopes[i][1] > envelopes[j][1]
		} else {
			return envelopes[i][0] < envelopes[j][0]
		}
	})

	n := len(envelopes)
	if n <= 1 {
		return n
	}

	size := 0
	c := make([]int, 0)

	for i := 0; i < n; i++ {
		l, r := 0, size-1
		for l <= r {
			mid := (l + r) / 2
			if c[mid] >= envelopes[i][1] {
				r = mid - 1
			} else {
				l = mid + 1
			}
		}

		if l < size {
			c[l] = envelopes[i][1]
		} else {
			c = append(c, envelopes[i][1])
			size = fmax(size, l+1)
		}
	}

	return size
}

func MainRussianDoll() {
	fmt.Println(maxEnvelopes([][]int{{5, 4}, {6, 4}, {6, 7}, {2, 3}})) //expected 3
}
