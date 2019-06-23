/**
 * 24 点游戏
 * 
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * 
 * 示例 1:
 * 
 * 输入: [4, 1, 8, 7] 输出: True 解释: (8-4) * (7-1) = 24 示例 2:
 * 
 * 输入: [1, 2, 1, 2] 输出: False 注意:
 * 
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 -
 * 1 是不允许的。 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 *
 */
public class Solution679 {
	
	public boolean judgePoint24(int[] nums) {
		double[] temp = new double[4];
		for(int i = 0; i < 4; i++) temp[i] = (double) nums[i];
		return solve(temp, 4);
	}
	
	public boolean solve(double[] nums, int len){
		if(len == 0) return false;
		else if(len == 1) {
			double ans = nums[0] - 24;
			return (ans < 0 ? -ans : ans) < 1e-6;
		}else{
			int a;
			double[] temp;
			for(int i = 0; i < len; i++){
				for(int j = 0; j < len; j++){
					if(i == j) continue;
					temp = new double[3];
					a = 0;
					for (int k = 0; k < len; k++) if(k != i && k != j) temp[a++] = nums[k];
					for(int k = 0; k < 4; k++){
						if(k == 0 && j <= i){
							temp[a] = nums[i] + nums[j];
						}else if(k == 1 && j <= i){
							temp[a] = nums[i] * nums[j];
						}else if(k == 2){
							temp[a] = nums[i] - nums[j];
						}else if(k == 3 && nums[j] == 0) {
							continue;
						}else{
							temp[a] = nums[i] / nums[j];
						}
						if(solve(temp, a + 1)) return true;
					}
				}
			}
			return false;
		}
	}
}
