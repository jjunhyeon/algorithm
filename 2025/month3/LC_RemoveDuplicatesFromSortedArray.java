package month3;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 * 2025-03-12 today (12: 30 ~ 12: 55)
*/
public class LC_RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		solution(nums);
	}

	// change the array nums such that the first k
	// remove the duplicates in-place such that each unique element appears only once.
	private static int solution(int[] nums) {
		int p1 = 0;
		int len = nums.length;
		for(int i=1; i<len; i++) {
			// 값이 동일하다면 nums[p1 + 1] 을 현재 가르키는 인덱스 지점의 값으로 업데이트
			// p1 을 i로 업데이트
			if(nums[p1] != nums[i]) {
				p1++;
				nums[p1] = nums[i];
			} 
		}
		return p1 + 1;  // 중복 제거 후 배열의 길이 반환
	}
}
