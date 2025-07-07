package year2025.month7;

/*
* 카데인알고리즘
* 이전 부분 배열의 합을 이용해 현재까지의 합과 현재 위치의 값의 MAX 를 비교해 구하면 끝난다.
* 10:30 ~ 11:00
* 카데인알고리즘 학습
* 
*/
public class MaximumSubArray_0706 {
	public static void main(String[] args) {
		int[] num1 = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		solution(num1);
	}

	/**
	 * @param num : 문제
	 * @return 최대값
	 */
	private static int solution(int[] num) {
		int max =num[0];
		int len = num.length;
		
		int answer = Integer.MIN_VALUE;
		for(int i=1; i<len; i++) {
			max = Math.max(num[i], max +  num[i]); // 현재까지의 loop가 탐색하는 시점에서의 최댓값
			answer = Math.max(answer, max); // 전체 루프 내에서의 최대값 탐색을 위함
		}
		return answer;
	}
}
