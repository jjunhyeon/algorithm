package year2025.month7;

/*
* Given an integer array nums, find a subarray that has the largest product, and return the product.
* 
* 필요한 생각)
* 음수 × 음수 = 양수 → 한 번의 음수는 결과를 작게 만들지만, 두 번 음수는 양수가 되어 최댓값이 될 수 있음
* 0이 나오면 곱이 끊긴다 → 새롭게 시작해야 할 수도 있음
* 즉, 단순히 이전 값 * 현재 값만 생각으론 추적 못함
* 
* -> 
* maxDp[i] = arr[i] 중, i를 포함한 최댓값 곱
* minDp[i] = arr[i] 중, i를 포함한 최솟값 곱
* 
* 점화식!
* maxDp[i] = max(arr[i], arr[i] * maxDp[i-1], num[i] * minDp[i-1]);
* minDp[i] = min(arr[i], arr[i] * maxDp[i-1], num[i] * minDp[i-1]);
*  
*/
public class MaximumProductSubArray_0707 {
	public static void main(String[] args) {
		int[] arr1 = new int[] {2,-1,1,1}; 
		solution(arr1);
	}

	private static int solution(int[] arr) {
		int len = arr.length;
		
		if(len == 1) {
			return arr[0];
		} 
		
		int curMax = arr[0];
		int curMin = arr[0];
		int answer = arr[0];
		for(int i=1; i<len; i++) {
			int temp = curMax;
			curMax = Math.max(arr[i], Math.max(arr[i] * curMax, arr[i] * curMin));
			curMin = Math.min(arr[i], Math.min(arr[i] * temp, arr[i] * curMin));
			answer = Math.max(answer, curMax);
		}
		return answer;
	}
}
