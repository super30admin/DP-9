function findNumberOfLIS(nums: number[]): number {
  let dp: Map<number, number[]> = new Map();
  let lisLength = 0;
  let lisCount = 0;

  for (let i = nums.length - 1; i >= 0; i--) {
    let iLength = 1;
    let iCount = 1;
    for (let j = i + 1; j <= nums.length - 1; j++) {
      if (nums[j] > nums[i]) {
        let memory = dp.get(j)!;
        let jLength = memory[0];
        let jCount = memory[1];
        if (jLength + 1 > iLength) {
          iLength = jLength + 1;
          iCount = jCount;
        } else if (jLength + 1 == iLength) {
          iCount += jCount;
        }
      }
    }

    if (iLength > lisLength) {
      lisLength = iLength;
      lisCount = iCount;
    } else if (iLength == lisLength) {
      lisCount += iCount;
    }

    dp.set(i, [iLength, iCount]);
  }
  console.log(dp);
  return lisCount;
}

describe("673. Number of Longest Increasing Subsequence", () => {
  it("Happy Path - 01", () => {
    expect(findNumberOfLIS([1, 3, 5, 4, 7])).toEqual(2);
  });

  it("Happy Path - 02", () => {
    expect(findNumberOfLIS([3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12])).toEqual(2);
  });

  it("Happy Path - 03", () => {
    expect(findNumberOfLIS([1, 2])).toEqual(1);
  });
});
