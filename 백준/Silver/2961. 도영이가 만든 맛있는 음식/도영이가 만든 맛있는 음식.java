
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int result = Integer.MAX_VALUE;
	static int[] sin, dan;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// sin맛과 dan맛
		sin = new int[N];
		dan = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			dan[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		boolean[] visited = new boolean[N];
		dfs(0, 0, visited, 1, 0);
		System.out.println(result);
	}

	private static void dfs(int start, int depth, boolean[] visited, int curSin, int curDan) {

		if (depth > 0) {
			result = Math.min(result, Math.abs(curSin - curDan));
		}

		if (depth == N) {
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(start, depth + 1, visited, curSin * sin[i], curDan + dan[i]);
				visited[i] = false;
			}
		}
	}
}
