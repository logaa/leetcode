/**
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC" 输出: "BANC" 说明：
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 */
public class Solution76 {
	 
	 public String minWindow(String s, String t) {
		    if(s.equals(t)) return t;
	        char[] sChars = s.toCharArray(), tChars = t.toCharArray();
	        if(sChars.length < tChars.length) return "";
	        int[] tMap = new int[128];
	        int l = 0, r = 0;
	        int count = tChars.length;
	        int minLen = s.length() + 1, b = 0, e = 0;
	        for (char tChar : tChars) tMap[tChar]++;
	        while (r < sChars.length) {
	            if (tMap[sChars[r]] > 0) count--;
	            tMap[sChars[r]]--;
	            r++;
	            while (count == 0) {
	            	int len = r-l;
	                if (len < minLen) {
	                    minLen = len;
	                    b = l;
	                    e = r;
	                }
	                tMap[sChars[l]]++;
	                if (tMap[sChars[l]] > 0) count++;
	                l++;
	            }
	        }
	        return minLen == s.length() + 1 ? "" : s.substring(b, e);
	    }
}
