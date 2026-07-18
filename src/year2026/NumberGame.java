package year2026;

import java.util.Arrays;

public class NumberGame {
	public static void main(String[] args) {
		int[] arr1 = new int[] {5,1,3,7};
		int[] arr2 = new int[] {2,2,6,8};
		int result = solution(arr1,arr2);
		System.out.println("result ::" + result);
	}

	/**
	 * 숫자게임
	 * A 팀의 게임 스코어를 알 수 있을 때, B 팀의 스코어를 조합 할 수 있을경우
	 * 가장 많이 이기는 스코어를 찾아내라.
	 */
	private static int solution(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		// arr1과 arr2의 사이즈는 같음
		int len = arr1.length;
		int answer = 0;
		int idx = 0;
		for(int i=0; i<len; i++) {
			int value = arr1[i];
			while(idx < len) {
				int target = arr2[idx];
				idx++;
				if(value < target) {
					answer ++;
					break;
				}
			}
		}
		return answer;
	}
}
