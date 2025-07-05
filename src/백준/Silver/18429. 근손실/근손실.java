
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int answer = 0;
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 범위, 근손실값
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] visited = new boolean[N];
		dfs(0,visited,0);
		System.out.println(answer);
	}

	private static void dfs(int depth, boolean[] visited, int current) {
		
		if(current < 0) {
			return;
		}
		
		if(depth == N) {
			answer ++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				// 깊이 +1, 방문여부, 근손실 정도를 파악하기 위한 current value
				dfs(depth + 1, visited, current + array[i] - K);
				visited[i] = false;
			}
		}
		
	}
}
