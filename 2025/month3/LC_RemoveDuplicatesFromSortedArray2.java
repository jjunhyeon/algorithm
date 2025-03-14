package month3;

// 12 : 30 ~ 13 :00
// 03-13 leetCode
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
// 문제에대한 고민 다시 필요
public class LC_RemoveDuplicatesFromSortedArray2 {
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		System.out.println(solution(nums));
	}

	private static int solution(int[] nums) {
		int p1=0;
		int len = nums.length;
		int sum = 1;
		for(int i=1; i<len; i++) {
			if(nums[p1] == nums[i]) {
				sum ++;
			} else {
				sum = 1;
			}
			
			if(sum <= 2) {
				p1 ++;
				nums[p1] = nums[i];
			}
		}
		
        // 남은 부분을 0으로 채우기
        for (int i = p1 + 1; i < len; i++) {
            nums[i] = 0;
        }
		
		return p1 + 1;
	}
}
