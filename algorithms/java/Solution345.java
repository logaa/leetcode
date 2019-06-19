/**
 * 
 * 反转字符串中的元音字母
 * 
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1: 输入: "hello" 输出: "holle"
 * 
 * 示例 2: 输入: "leetcode" 输出: "leotcede" 说明: 元音字母不包含字母"y"。
 *
 *
 */
public class Solution345 {
	public String reverseVowels(String s) {
		char[] ss = s.toCharArray();
		String w = "aeiouAEIOU";
		int l = 0, r = ss.length - 1;
		char a, b, t;
		while(l < r) {
			a = 0;
			b = 0;
			while (l < r) {
				if(w.indexOf(ss[l]) > -1) a = ss[l];
				if(a != 0) break;
				l++;
			}
			while (l < r) {
				if(w.indexOf(ss[r]) > -1) b = ss[r];
				if(b != 0) break;
				r--;
			}
			if(a != 0 && b != 0) {
				t = ss[l];
				ss[l] = ss[r];
				ss[r] = t;
				r--;
				l++;
			}
		}		
		return String.valueOf(ss);
	}
}
