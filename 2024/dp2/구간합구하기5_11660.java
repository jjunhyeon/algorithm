package dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 - 구간 합 구하기5
public class 구간합구하기5_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		// 문제 처리를 위해 가로, 세로 한칸씩 크게 잡는다
		int[][] matrix = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			// 입력 한줄 row 만큼 받는다.
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp 배열엔 row를 기준으로 누적 합 정보를 저장한다.
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			int temp = 1;
			while (temp <= N) {
				dp[i][temp] = dp[i][temp - 1] + matrix[i][temp];
				temp++;
			}
		}

		// START
		while (T-- > 0) {
			String[] line = bf.readLine().split(" ");
			int startX = Integer.parseInt(line[0]);
			int startY = Integer.parseInt(line[1]);
			int targetX = Integer.parseInt(line[2]);
			int targetY = Integer.parseInt(line[3]);
			if (startX == targetX && startY == targetY) {
				bw.append(Integer.toString(matrix[startX][startY]));
			} else {
				// 시작지점의 Y가 1이라면 하나의 row 전체를 구하면 됨
				int sum = 0;
				while (startX <= targetX) {
					sum += (startY == 1) ? dp[startX][targetY] : (dp[startX][targetY] - dp[startX][startY - 1]);
					startX++;
				}
				bw.append(Integer.toString(sum));
			}
			bw.newLine();
		}
		bf.close();
		bw.close();
	}
}
