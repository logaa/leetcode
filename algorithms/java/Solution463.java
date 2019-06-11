
/**
 * 
 *
给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

示例 1:

输入: [1,12,-5,-6,50,3], k = 4
输出: 12.75
解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 
注意:

1 <= k <= n <= 30,000。
所给数据范围 [-10,000，10,000]。
 *
 */
public class Solution463 {

	public double findMaxAverage(int[] nums, int k) {
		double maxSum = 0, lastSum = 0;
		int i, s = nums.length - k;
		if(k == nums.length) {
			for (int j : nums) maxSum += j;
			return maxSum /= k; 
		}
		for (i = 0; i < k; i++) lastSum += nums[i];
		maxSum = lastSum;
		for (i = 0; i < s; i++) {
			lastSum += nums[i+k] - nums[i];
			if(lastSum > maxSum) maxSum = lastSum;
		}
		return maxSum /= k;
    }
}
