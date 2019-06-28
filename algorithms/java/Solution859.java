/**
 * 
 * 
给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。

示例 1：
输入： A = "ab", B = "ba"
输出： true

示例 2：
输入： A = "ab", B = "ab"
输出： false

示例 3:
输入： A = "aa", B = "aa"
输出： true

示例 4：
输入： A = "aaaaaaabc", B = "aaaaaaacb"
输出： true

示例 5：
输入： A = "", B = "aa"
输出： false
 
提示：

0 <= A.length <= 20000
0 <= B.length <= 20000
A 和 B 仅由小写字母构成。

 * 
 *
 */
public class Solution859 {
	
	 	public boolean buddyStrings(String A, String B) {
	 		boolean isBuddy = false;
	 		if(A.length() != B.length()) return isBuddy;
	 		char[] aChars = A.toCharArray(), bChars = B.toCharArray();
	 		if(A.equals(B)) {
	 			int[] c = new int[26];
	 			for (int a : aChars) c[a-97]++;
	 			for (int i : c) {
					if(i > 1) {
						isBuddy = true; 
						break;
					}
				}
	 			return isBuddy;
	 		}
	 		int[] pair = new int[2];
	 		int x = 0;
	 		for (int i = 0; i < bChars.length; i++) {
				if(aChars[i] != bChars[i]) {
					pair[x++] = i;
					if(x == 2) break;
				}
			}
	 		if(x == 2) {
	 			char t = aChars[pair[0]];
	 			aChars[pair[0]] = aChars[pair[1]];
	 			aChars[pair[1]] = t;
	 			A = String.valueOf(aChars);
	 			if(A.equals(B)) isBuddy = true;
	 		}
	 		return isBuddy;
	    }
}
