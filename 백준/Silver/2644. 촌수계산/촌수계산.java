
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// GRAPH, BFS 문제
// 문제 설명
// : 1,2,3 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다.
// : 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다.
// : 이떄 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
public class Main {
	// 전체 관계의 정보를 저장할 그래프 변수 선언
	static ArrayList<ArrayList<Integer>> GRAPH = new ArrayList<>();
	// 방문여부를 검증하기 위함
	static boolean[] visited;
	// 전체 명 수, 시작값, 목표, 촌수 관계의 수
	static int N, START, END, COUNT;

	public static void main(String[] args) throws Exception, IOException {
		// 1. 입력값 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];
		// 촌수를 계산해야하는 두 사람의 번호 a,b
		StringTokenizer st = new StringTokenizer(br.readLine());
		START = Integer.parseInt(st.nextToken());
		END = Integer.parseInt(st.nextToken());
		// 촌수의 수
		COUNT = Integer.parseInt(br.readLine());
		// 관계 초기화
		for (int i = 0; i <= N; i++)
			GRAPH.add(new ArrayList<>());

		// 촌수에 대한 관계연결
		for (int i = 0; i < COUNT; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// X는 뒤에 나오는 정수 Y의 부모 번호를 나타낸다.
			GRAPH.get(x).add(y);
			GRAPH.get(y).add(x);
		}
		System.out.println(graphSearchByBfs());
	}

	// 그래프를 bfs로 탐색한다.
	private static int graphSearchByBfs() {
		int answer = 0;
		// int [START,DEPTH] 정보를 담을 배열 정보로 생성
		Queue<int[]> myQ = new LinkedList<>();
		// 시작값 적용
		myQ.offer(new int[] {START,0});
		visited[START] = true;
		while (!myQ.isEmpty()) {
			int[] cur = myQ.poll();
			int start = cur[0];
			int depth = cur[1];
			// 시작값안에 목표로 하는 값이 있을경우
			// 값을 증가시키고 종료
			if (GRAPH.get(start).contains(END)) {
				answer = depth+1;
				break;
			}
			for (final Integer next : GRAPH.get(start)) {
				if (!visited[next]) {
					visited[next] = true;
					myQ.offer(new int[] {next,depth+1});
				}
			}
		}

		return answer == 0 ? -1 : answer;
	}
}
