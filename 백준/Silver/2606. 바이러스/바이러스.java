
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<Integer>> MAP = new ArrayList<>();
		// 컴퓨터의 수
		int computerCount = Integer.parseInt(br.readLine());

		HashSet<Integer> answer = new HashSet<>();
		// 커넥션의 수
		boolean[] visited = new boolean[computerCount + 1];
		int connectionCount = Integer.parseInt(br.readLine());
		// 1번 컴퓨터를 기준으로해서 어디까지 전파되는지 확인해야한다.
		// 관계를 그래프로 만들고 양방향그래포 1번 q를 넣어서 너비 탐색을 한다.
		// 컴퓨터의 수만큼 초기화
		for (int i = 0; i <= computerCount; i++) {
			MAP.add(new ArrayList<>());
		}
		StringTokenizer st;
		for (int i = 0; i < connectionCount; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			MAP.get(start).add(end);
			MAP.get(end).add(start);
		}

		// 탐색 시작
		Queue<Integer> myQ = new LinkedList<>();
		// 초기 바이러스 시작은 1번 컴퓨터 고정
		myQ.offer(1);
		visited[1] = true;
		while (!myQ.isEmpty()) {
			int cur = myQ.poll();
			for (final Integer item : MAP.get(cur)) {
				if (!visited[item]) {
					answer.add(item);
					myQ.offer(item);
					visited[item] = true;
				}

			}
		}

		System.out.println(answer.size());
		br.close();
	}
}
