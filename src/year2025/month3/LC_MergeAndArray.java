package src.year2025.month3;

/*
 * https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 * 정렬된 수 반환
 * 2025-03-04 today (12: 30 ~ 12: 55)
 * 문제파악
*/
public class LC_MergeAndArray {
	public static void main(String[] args) {
		// example data
		int[] nums1 = {1,2,3,0,0,0};
		int num1 = 3;
		int[] nums2 = {2,5,6};
		int num2 = 3;
		
		// 예시에 대한 리턴 => {1,2,2,3,5,6}
		solution(nums1, num1, nums2, num2);
	}

	// return : merged array1
	// @note : the final sorted array should not be returned by the function
	// but instead be stored inside the array nums1.
	private static void solution(int[] nums1, int num1, int[] nums2, int num2) {
		//num1은 nums1의 길이
		//num2는 nums2의 길이
		int T = nums1.length - 1;
		int p1 = num1 - 1;
		int p2 = num2 - 1;
		while(T >= 0) {
			if(p1 < 0) {
				nums1[T] = nums2[p2];
				p2--;
			} else if(p2 < 0) {
	            nums1[T] = nums1[p1];
	            p1--;
			} else if(nums1[p1] > nums2[p2]) {
				nums1[T] = nums1[p1];
				p1 --;
			} else {
				nums1[T] = nums2[p2];
				p2 --;
			}
			T--;
		}
	}
}
