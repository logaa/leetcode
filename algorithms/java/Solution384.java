import java.util.Random;

/**
 * 
打乱一个没有重复元素的数组。

示例:

// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
 *
 */
public class Solution384 {
	
	private int[] nums;
	
    public Solution384(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	int[] newNums = nums.clone();
    	Random random = new Random();
    	int i = newNums.length - 1, randomNum;
    	for (; i > 0; i--) {
    		randomNum = random.nextInt(i + 1);
    		if(randomNum == i) continue;
    		newNums[i] = newNums[i] + newNums[randomNum];
    		newNums[randomNum] = newNums[i] - newNums[randomNum];
    		newNums[i] = newNums[i] - newNums[randomNum];
		}
    	return newNums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */