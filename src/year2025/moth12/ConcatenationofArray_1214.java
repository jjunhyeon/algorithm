package year2025.moth12;

import java.util.Arrays;

/**
 * Given an integer array nums of length n, you want to create an array 
 * ans of length 2n where ans[i] == nums[i] 
 * and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 */

public class ConcatenationofArray_1214 {
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,1};
		System.out.println(Arrays.toString(getConcatenation(nums)));
	}
	
	// 기존 파라미터의 배열을 2N 사이즈로 만들고 값도 동일하게 해라.
	public static int[] getConcatenation(int[] nums) {
		int len = nums.length * 2;
		int[] ans = new int[len];
		for(int i=0; i<len; i++) {
			ans[i] = nums[i >= nums.length ? i - nums.length : i];
		}
		return ans;
	}
}

