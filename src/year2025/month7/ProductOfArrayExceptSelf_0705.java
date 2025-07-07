package year2025.month7;


/*
* Product of Array Except Self
* 주어진 배열에서 자신의 위치값에 해당하는 배열 값만 제외하고 곱한값을 배열에 담아 리턴해라.
* O(n) 이하로 해결이니 for 루프 한번 이하
* 4: 50 ~ 5:00 
* -> 하지만 O(N^2) 해결
* -> 왼쪽곱 이후 오른쪽 곱 O(n) 루프 2번으로 해결
* 해당 사고가 처음엔 잘 떠오르지 않았음, 결국 해결과정을 찾아봄
* 다시 풀어볼문제
*/
public class ProductOfArrayExceptSelf_0705 {
	public static void main(String[] args) {
		int[] num1 = new int[] {1,2,3,4};
		int[] num2 = new int[] {-1,-1,0,-3,-3};
		// 이중포문 해결 O(N^2) -> 최악
		//solution(num2);
		// O(n) 해결하기
		solution_new(num1);
	}

	private static int[] solution_new(int[] num) {
		int len = num.length;
		int[] answer = new int[len];
		answer[0] = 1;
		for(int i=1; i < len; i++) {
			answer[i] = answer[i-1] * num[i- 1];
		}
		
		int right = 1;
		for(int j=len-1; j>=0; j--) {
			// 자기 자신을 곱하지 않을거임, answer 선반영
			answer[j] *= right;
			right *= num[j];
		}
		
		return answer;
	}

	private static int[] solution(int[] num) {
		// 정답 배열 선언
		int len = num.length;
		int[] answer = new int[len];
		
		// 전체 곱에 대한 정보를 미리 담아놓고 내 자신을 나누어 리턴한다.
		for(int i=0; i<len; i++) {
			int target = 1;
			for(int j=0; j<len; j++) {
				if(i == j) continue;
				target *= num[j];
			}
			answer [i] = target;
		}
		
		return answer;
	}
}
