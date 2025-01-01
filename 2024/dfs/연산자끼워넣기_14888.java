package dfs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888 {
	static int[] numArray;
	static String[] info;
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		numArray = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}

		info = new String[N - 1];

		st = new StringTokenizer(br.readLine());

		// 4개 연산식 고정이므로
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

		boolean[] visited = new boolean[N - 1];
		dfs(visited, 0, numArray[0], N);
		
		bw.append(String.valueOf(MAX)).append("\n");
		bw.append(String.valueOf(MIN));
		bw.flush();
		br.close();
		bw.close();
	}

	private static void dfs(boolean[] visited, int depth, int currentResult, int N) {

		if (depth == N - 1) {
			// caculate stringBuilde
			MAX = Math.max(currentResult, MAX);
			MIN = Math.min(currentResult, MIN);
			return;
		}

		int loopSize = info.length;
		for (int i = 0; i < loopSize; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int current = calculate(currentResult, numArray[depth + 1], info[i]);
				dfs(visited, depth + 1, current, N);
				visited[i] = false;
			}
		}
	}

	private static int calculate(int currentResult, int nextValue, String condition) {
		// TODO Auto-generated method stub
		int result = 0;
		if (condition.equals("+")) {
			result = currentResult + nextValue;
		} else if (condition.equals("-")) {
			result = currentResult - nextValue;
		} else if (condition.equals("*")) {
			result = currentResult * nextValue;
		} else {
			result = currentResult / nextValue;
		}
		return result;
	}
}
