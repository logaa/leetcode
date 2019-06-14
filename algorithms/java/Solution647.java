/**
 * 

回文子串
 
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

示例 1:
输入: "abc"
输出: 3
解释: 三个回文子串: "a", "b", "c".

示例 2:
输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
注意:

输入的字符串长度不会超过1000。

 *
 */
public class Solution647 {
	
	public int countSubstrings(String s) {
		int len = s.length(), count = len, l = -1, r = len, b, e;
		while(r > 1) {
			b = l;
			e = r;
			while (e <= len) {
				if(backToText(s, b, e)) count ++;
				b++;
				e++;
			}	
			r--;
		}
        return count;
    }

	private boolean backToText(String s, int l, int r) {
		boolean f = true;
		while(++l < --r) {
			if(s.charAt(l) != s.charAt(r)) {
				f = false;
				break;
			}
		}
		return f;
	}
	
}
