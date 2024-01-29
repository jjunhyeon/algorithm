import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 - 배낭 만들기
public class Boj_배낭만들기_12865 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		
		// Test case와 무게 변수 값
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		// 입력 받자
		int[][] inputValue = new int[T+1][2];
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(bf.readLine());
			// 1변째 컬럼엔 무게 정보를 , 2번째 컬럼엔 가치 정보를 담는다.
			inputValue[i][0] = Integer.parseInt(st.nextToken());
			inputValue[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 무게별, 최대 가중치 정보를 저장한다.
		int[][] dp = new int[T+1][W+1];
		
		// 입력값
		for(int i=1; i<=T; i++) {
			for(int j=1; j<=W; j++) {
				// 담을 수 있는 최대 무게보다 현재 담으려는게 작다면
				if(j >= inputValue[i][0]) {
					// 이전 최대 무게 vs 현재 넣으려는 물건의 가치 + 여분의 사이즈의 공간에 해당하는 최대 가치 
					dp[i][j] = Math.max(dp[i-1][j], inputValue[i][1] + dp[i-1][j - inputValue[i][0]]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		System.out.println(dp[T][W]);
	}
}
