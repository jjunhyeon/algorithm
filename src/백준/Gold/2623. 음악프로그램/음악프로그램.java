
// 줄세우기(2252) 문제와 유사한 위사정렬 문제
// 위상정렬의 핵심은 비순환그래프, 간선정보가 없는 노드부터 정리, 큐를 사용한다.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] SINGER;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력값 1 ) 첫번쨰 가수의 수, 가수들의 순서 정보 수
		int SINGER_COUNT = Integer.parseInt(st.nextToken());
		int INFO_ROW = Integer.parseInt(st.nextToken());

		SINGER = new int[SINGER_COUNT + 1];
		// 그래프 정보 초기화
		for (int i = 0; i <= SINGER_COUNT; i++) {
			graph.add(new ArrayList<>());
		}

		// 입력값 2) 순서 관계 정보
		for (int i = 0; i < INFO_ROW; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			int start = 0;
			int target = 0;
			for (int j = 0; j < count; j++) {
				if (start == 0) {
					start = Integer.parseInt(st.nextToken());
				} else if (target == 0) {
					target = Integer.parseInt(st.nextToken());
				} else {
					start = target;
					target = Integer.parseInt(st.nextToken());
				}
				if (start != 0 && target != 0) {
					graph.get(start).add(target);
					SINGER[target]++;
				}
			}
		}

		Queue<Integer> myQ = new LinkedList<>();
		// 진입차수가 0인 값을 큐에 넣어야한다.
		for (int i = 1; i <= SINGER_COUNT; i++) {
			if (SINGER[i] == 0) {
				myQ.offer(i);
			}
		}

		while (!myQ.isEmpty()) {
			int cur = myQ.poll();
			sb.append(String.valueOf(cur)).append("\n");
			for (final int next : graph.get(cur)) {
				// 값 감소
				SINGER[next]--;
				if (SINGER[next] == 0) {
					myQ.offer(next);
				}
			}
		}
		System.out.println(sb.length() / 2 < SINGER_COUNT ? 0 : sb);
		br.close();
	}
}
