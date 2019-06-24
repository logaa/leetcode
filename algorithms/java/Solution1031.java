/**
 * 
 * 两个非重叠子数组的最大和
 * 
 * 给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。 （这里需要澄清的是，长为 L
 * 的子数组可以出现在长为M 的子数组之前或之后。） 从形式上看，返回最大的 V，而 V = (A[i] + A[i+1] + ... + A[i+L-1])
 * + (A[j] + A[j+1] + ... + A[j+M-1]) 并满足下列条件之一： 0 <= i < i + L - 1 < j < j + M
 * - 1 < A.length, 或 0 <= j < j + M - 1 < i < i + L - 1 < A.length.  
 * 
 * 示例 1： 输入：A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2 输出：20 解释：子数组的一种选择中，[9] 长度为
 * 1，[6,5] 长度为 2。
 * 
 * 示例 2： 输入：A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2 输出：29 解释：子数组的一种选择中，[3,8,1] 长度为
 * 3，[8,9] 长度为 2。
 * 
 * 示例 3： 输入：A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3 输出：31 解释：子数组的一种选择中，[5,6,0,9]
 * 长度为 4，[0,3,8] 长度为 3。  
 * 
 * 提示： L >= 1 M >= 1 L + M <= A.length <= 1000 0 <= A[i] <= 1000
 *
 * 
 */
public class Solution1031 {

	public int maxSumTwoNoOverlap(int[] A, int L, int M) {
		int sum = 0;
		if(L + M == A.length) {
			for (int i : A) sum += i;
			return sum;
		}
		if(L < M) {
			L = L + M;
			M = L - M;
			L = L - M;
		}
		int len1 = A.length - L, len2 = A.length - M, s1 = 0;
		for (int b1 = 0; b1 <= len1; b1++) {
			int e1 = b1 + L, sum2 = 0;
			if(b1 > 0) s1 = s1 - A[b1 - 1] + A[e1 - 1];
			else for (int i = b1; i < e1; i++) s1 += A[i];
			int s2 = 0, len = b1 - M + 1;
			for (int b2 = 0; b2 < len; b2++) {
				int e2 = b2 + M;
				if(b2 > 0) s2 = s2 - A[b2 - 1] + A[e2 - 1];
				else for (int i = b2; i < e2; i++) s2 += A[i];
				sum2 = s2 > sum2 ? s2 : sum2;
			}
			int b = b1 + L + 1;
			s2 = 0;
			for (int b2 = b; b2 <= len2; b2++) {
				int e2 = b2 + M;
				if(b2 > b) s2 = s2 - A[b2 - 1] + A[e2 - 1];
				else for (int i = b2; i < e2; i++) s2 += A[i];
				sum2 = s2 > sum2 ? s2 : sum2;
			}
			sum = s1 + sum2 > sum ? s1 + sum2 : sum;
		}
		return sum;
	}
}
