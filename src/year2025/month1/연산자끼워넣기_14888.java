package src.year2025.month1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 *  01-04
 *  https://covenant.tistory.com/224
 *  취약 유형 체크
 *  재귀 탐색 기본 문제
 *  문제에 대한 이해
 */
public class 연산자끼워넣기_14888 {
	static int N;
	static int[] numArray;
	static String[] info;
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		numArray = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}

		info = new String[N - 1];
		st = new StringTokenizer(br.readLine());
		// 4개 연산식 고정
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int M = Integer.parseInt(st.nextToken());
			while (M-- > 0) {
				if (i == 0) {
					info[idx] = "+";
				} else if (i == 1) {
					info[idx] = "-";
				} else if (i == 2) {
					info[idx] = "*";
				} else {
					info[idx] = "/";
				}
				idx++;
			}
		}

		boolean visited[] = new boolean[N - 1];
		dfs(0, numArray[0], visited);
		bw.append(String.valueOf(MAX)).append("\n");
		bw.append(String.valueOf(MIN));
		bw.flush();
		br.close();
		bw.close();
	}

	private static void dfs(int depth, int sum, boolean[] visited) {
		// 연산자가 모두 선택된 순간 == N - 1
		if (depth == N - 1) {
			// calculate stringBuilde
			MAX = Math.max(sum, MAX);
			MIN = Math.min(sum, MIN);
			return;
		}
		for (int i = 0; i < N - 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				// 초기값은, 먼저 numArray[0]은 선택되었고 다음 depth+1 만큼의 1번쨰 값과 info[0]은 가장 초기의 연산자의 값
				int current = calculate(sum, numArray[depth + 1], info[i]);
				dfs(depth + 1, current, visited);
				visited[i] = false;
			}
		}
	}

	// calculate value
	private static int calculate(int sum, int nextValue, String mean) {
		int calculated = 0;
		if ("+".equals(mean))
			calculated = sum + nextValue;
		else if ("-".equals(mean))
			calculated = sum - nextValue;
		else if ("*".equals(mean))
			calculated = sum * nextValue;
		else if ("/".equals(mean))
			calculated = sum / nextValue;
		return calculated;
	}
}
