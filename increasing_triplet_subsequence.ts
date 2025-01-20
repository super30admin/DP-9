function increasingTriplet(nums: number[]): boolean {
  let effectiveArray: number[] = Array.from({ length: nums.length });
  effectiveArray[0] = nums[0];
  let len = 1;
  function search(value: number): number {
    let left = 0;
    let right = len - 1;
    while (left <= right) {
      let mid = Math.floor(left + (right - left) / 2);
      if (effectiveArray[mid] == value) return mid;
      else if (effectiveArray[mid] > value) right = mid - 1;
      else left = mid + 1;
    }
    return left;
  }

  for (let i = 1; i < nums.length; i++) {
    if (nums[i] > effectiveArray[len - 1]) {
      effectiveArray[len] = nums[i];
      len++;
    } else {
      let idx = search(nums[i]);
      effectiveArray[idx] = nums[i];
    }
  }
  return len >= 3;
}

describe("334. Increasing Triplet Subsequence", () => {
  it("Happy Path - 01", () => {
    expect(increasingTriplet([1, 2, 3, 4, 5])).toEqual(true);
    expect(increasingTriplet([1, 2, 3, 4, 5])).toEqual(true);
  });
});
