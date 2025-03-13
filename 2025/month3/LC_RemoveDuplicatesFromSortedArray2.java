package month3;


// 12 : 30 ~ 13 :00
// 03-13 leetCode
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
// 문제에대한 고민 다시 필요
public class LC_RemoveDuplicatesFromSortedArray2 {
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		solution(nums);
	}

	private static int solution(int[] nums) {
		int answer = 0;
		
		int p1=0;
		int len = nums.length;
		int sum = 1;
		for(int i=1; i<len; i++) {
			// 누적카운트가 3이 된다면 lenth를 1 증가시킨다.
			// nums[i] 의 동일 누적 value값이 3이상이 된다면 
			// 무시하고 다음 index로 넘겨야한다.
			// 다음 index가 신규 값이 나왔을경우 
			// nums[i]에 해당 값으로 업데이트하고 누적 카운트값을 1로 업데이트해준다.
			// 최종 p1의 가리키고 있는 길이에 + 1을 return
			//
			// 현재 가리키고 있는 값과 인덱스값이 일치하다면
			if(sum <= 2 && nums[p1] == nums[i]) {
				sum ++;
			}
			// 누적 값이 3
			if(sum > 2) {
				if(sum == 3) {
					p1 = i;
				}
				// p1의 위치는 현재 누적 index가 2를 넘긴그 지점이다.
				// 배열값이랑 여전히 일치하다면
				if(nums[p1] != nums[i]) {
					nums[p1] = nums[i];
					sum  = 1;
				} else {
					sum ++;
				}
			}
		}
		return answer;
	}
}
