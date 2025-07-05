
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, TARGET;
	static long answer = 0;
	static int[] arr;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		TARGET = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		boolean[] visited = new boolean[N];
		dfs(0,0, visited, 0);
		System.out.println(answer);
	}

	private static void dfs(int start, int depth, boolean[] visited, long cur) {

		// 전체 탐색했을떄 리턴시키기
		if (depth > 0 && cur == TARGET) {
			// == 정답 ++
			answer++;
		}
		
		if (depth == N) {
			return;
		}


		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, depth + 1, visited, cur + arr[i]);
				visited[i] = false;
			}
		}
	}
}
