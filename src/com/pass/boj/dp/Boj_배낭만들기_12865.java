import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

		// 무게별, 최대 가중치 정보를 저장한다.
		int[] dp = new int[W+1];
		
		while(T --> 0) {
			st = new StringTokenizer(bf.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			// 무게별, 최대 가중치 값으로 저장한다.
			dp[weight] = Math.max(dp[weight], value);
			
			// TO DO DFS로 더하기 케이스 구분 후 처리해야할듯..?
		}
		
	}
}
