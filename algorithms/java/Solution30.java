
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

示例 1：

输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]

解释：
从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。

示例 2：

输入：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出：[]

 *
 */
public class Solution30 {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		int size = words.length;
		if(s.length() == 0 || size == 0) return res;
		int wordLen = words[0].length();
		int totalWordLen = size * wordLen;
		if(totalWordLen > s.length()) return res;
		Set<String> keySet = new HashSet<String>();
		List<Integer> indexs = new ArrayList<Integer>();
		for (String word : words) {
			if(keySet.contains(word)) continue;
			int startIndex, endIndex, fromIndex = 0;
			while (fromIndex <= s.length()) { 
				startIndex = s.indexOf(word, fromIndex);
				endIndex =  startIndex + totalWordLen;
				if(startIndex < 0 || endIndex > s.length()) break;
				indexs.add(startIndex);
				fromIndex = startIndex + 1;
			}
			if(fromIndex > 0) keySet.add(word);
		}
		if(indexs.isEmpty()) return res;
		Map<String, Integer> wordTimesMap = new HashMap<String, Integer>();
		for (String word : words) wordTimesMap.put(word, wordTimesMap.getOrDefault(word, 0) + 1);
		Map<String, Integer> temp = new HashMap<String, Integer>();
		for (Integer index : indexs) {
			temp.putAll(wordTimesMap);
			int endIndex = index + totalWordLen;
			boolean isContainsKey = true;
			int fromIndex, toIndex, j = -1;
			while (++j < size) {
				fromIndex = index + j * wordLen;
				toIndex = fromIndex + wordLen;
				if(toIndex > endIndex) break;
				String subWord = s.substring(fromIndex, toIndex);
				if(temp.containsKey(subWord)){
					int wordTimes = temp.get(subWord);
					if(--wordTimes < 1) {
						temp.remove(subWord);
					}else {
						temp.put(subWord, wordTimes);
					}
				}else {
					isContainsKey = false;
					break;
				}
			}
			if(isContainsKey) res.add(index);
			temp.clear();
		}
        return res;
    }
}














