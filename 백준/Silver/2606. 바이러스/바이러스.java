
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 바이러스 - dfs, bfs
public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> MAP = new ArrayList<>();

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int COMPUTER_COUNT = Integer.parseInt(br.readLine());
		int CONNECTION_COUNT = Integer.parseInt(br.readLine());

		visited = new boolean[COMPUTER_COUNT + 1];
		// 초기화
		for (int i = 0; i <= COMPUTER_COUNT; i++) {
			MAP.add(new ArrayList<>());
		}

		StringTokenizer st;
		for (int i = 0; i < CONNECTION_COUNT; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			MAP.get(a).add(b);
			MAP.get(b).add(a);
		}
		System.out.println(searchByBFS());

	}

	private static int searchByBFS() {
		int answer = 0;
		Queue<Integer> myQ = new LinkedList<>();
		// START -> 1
		myQ.offer(1);
		visited[1] = true;
		while (!myQ.isEmpty()) {
			int cur = myQ.poll();
			for (Integer next : MAP.get(cur)) {
				if (!visited[next]) {
					visited[next] = true;
					myQ.offer(next);
					answer++;
				}
			}
		}

		return answer;
	}
}
