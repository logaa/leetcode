/**
 * 
负二进制转换

给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
除非字符串就是 "0"，否则返回的字符串中不能含有前导零。

示例 1：
输入：2
输出："110"
解释：(-2) ^ 2 + (-2) ^ 1 = 2

示例 2：
输入：3
输出："111"
解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3

示例 3：
输入：4
输出："100"
解释：(-2) ^ 2 = 4

提示：
0 <= N <= 10^9

 *
 *
 */
public class Solution1017 {

	public String baseNeg2(int N) {
		String mod = "";
		while(N != 1 && N != 0) {
			mod = Math.abs(N%-2) + mod;
			N = (int) Math.ceil(N/-2d);
			System.out.println(N);
		}
		if(N == 1) mod = 1 + mod;
		else if(N == 0) mod = "0";
        return mod;    
    }
}
