
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[5][5];
	static int statrtRow, startCol;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		statrtRow = Integer.parseInt(st.nextToken());
		startCol = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[5][5];
		dfs(statrtRow, startCol, visited, 0, 0);
		System.out.println(answer);
	}

	// 시작하는 row, col, 방문여부, depth
	private static void dfs(int row, int col, boolean[][] visited, int depth, int apple) {
		// validate
		// 노방문 + 값 이상무
		if (row < 0 || row >= 5 || col < 0 || col >= 5 || visited[row][col] || map[row][col] == -1) {
			return;
		}

		if (map[row][col] == 1) {
			apple++;
		}
		visited[row][col] = true;
		if (apple >= 2 || depth == 3) {
			if (apple >= 2) {
				answer = 1;
			}
			visited[row][col] = false; // 방문 여부 복구
			return;
		}

		dfs(row + 1, col, visited, depth + 1, apple);
		dfs(row - 1, col, visited, depth + 1, apple);
		dfs(row, col + 1, visited, depth + 1, apple);
		dfs(row, col - 1, visited, depth + 1, apple);
		visited[row][col] = false; // 모든 탐색이 끝난 후 방문 여부 복구
	}
}
