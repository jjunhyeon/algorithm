
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 기본문제 
// 1. 줄세우기
public class Main {
	static int[] deg;
	static ArrayList<ArrayList<Integer>> GRAPH = new ArrayList<>();
	static List<Integer> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int STUDENT_COUNT = Integer.parseInt(st.nextToken());
		int ROW = Integer.parseInt(st.nextToken());

		// deg 정보는 index 특성상 1칸 더 크게 잡는다.
		deg = new int[STUDENT_COUNT + 1];

		// 그래프 초기화
		for (int i = 0; i <= STUDENT_COUNT; i++)
			GRAPH.add(new ArrayList<>());

		// 그래프에 단방향 정보 세팅
		for (int i = 0; i < ROW; i++) {
			st = new StringTokenizer(bf.readLine());
			// 먼저나온값이 먼저 서야한다는 뜻은 그래프로 생각하면 B가 indegree 정보를 가진다는 의미이다.
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 단방향 그래프로 설정한다.
			// 위상정렬의 기본 조건
			GRAPH.get(a).add(b);
			deg[b]++;
		}

		Queue<Integer> myQ = new LinkedList<>();
		// 비어있는 노드에 대해 Q에 OFFER한다.
		for (int i = 1; i < GRAPH.size(); i++) {
			if (deg[i] == 0) myQ.offer(i);
		}

		// 비어있찌 않을때까지
		while (!myQ.isEmpty()) {
			int cur = myQ.poll();
			answer.add(cur);
			for (int next : GRAPH.get(cur)) {
				deg[next]--;
				if (deg[next] == 0)
					myQ.offer(next);
			}
		}

		for (int i = 0; i < answer.size(); i++) {
			bw.append(String.valueOf(answer.get(i)));
			if (i != answer.size() - 1) bw.append(" ");
		}
		
		bw.flush();
		bw.close();
		bf.close();
	}
}
