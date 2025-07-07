package year2025.month3;

/*
 * twom sum
 * link : https://leetcode.com/problems/two-sum/description/
 * O(N^2) 이하로 구현한다.
*/
public class LC_TwoSum {
	public static void main(String[] args) {
		int[] nums = { 3, 3 };
		int target = 6;
		solution(nums,target);
	}

	private static int[] solution(int[] nums, int target) {
		int start = 0;
		int len = nums.length;
		while (start < len) {
			for (int i = 0; i < len; i++) {
				if (start == i)
					continue;

				if (nums[i] + nums[start] == target) {
					return new int[] { start, i };
				}
			}
			start++;
		}
		return null;
	}
}
