package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 누적합_1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(bf.readLine());
		int[] arr = new int[K];
		
		// DP 배열엔 현재까지의 누적 최대값을 담는다.
		int[] dp = new int[K];
		Arrays.fill(dp, Integer.MIN_VALUE);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// set arr input
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}

		// 초기값
		int answer = dp[0] = arr[0];
		for(int i=1; i<K; i++) {
			// 0보다 작다면 현재 배열값으로 dp[i] 자리 대체한다.
			// 0보다 크다면 현재 값과 이전까지의 누적합을 비교해서 최대값으로 업데이트
			dp[i] = dp[i-1] + arr[i] > 0 ? dp[i] = Math.max(arr[i], dp[i-1] + arr[i]) : arr[i];
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
}
