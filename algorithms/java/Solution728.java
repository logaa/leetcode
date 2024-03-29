import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 自除数
 * 
 * 自除数 是指可以被它包含的每一位数除尽的数。 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 ==
 * 0。 还有，自除数不允许包含 0 。
 * 
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * 
 * 示例 1： 输入： 上边界left = 1, 下边界right = 22 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12,
 * 15, 22] 注意：
 * 
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 * 
 */
public class Solution728 {

	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<>();
		boolean f;
		String c;
		char d;
		do {
			f = true;
			c = String.valueOf(left);
			for (int i = 0; i < c.length(); i++) {
				d = c.charAt(i);
				if (d == 48 || left % (d - 48) != 0) {
					f = false;
					break;
				}
			}
			if (f) result.add(left);
		} while (++left <= right);
		return result;
	}
}
