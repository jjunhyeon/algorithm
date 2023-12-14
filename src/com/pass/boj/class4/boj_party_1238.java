import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준- 파티
// 다익스트라 문제
public class boj_party_1238 {

	public static int[] dist;
	public static ArrayList<ArrayList<Land>> landInfo = new ArrayList<>();
	public static int N, M, X;

	public static void main(String[] args) throws IOException {
		// 입력 값
		// 4 8 2
		// 1 2 4...
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		// 거리는 N + 1사이즈만큼
		dist = new int[N + 1];

		int answer = Integer.MIN_VALUE;

		// 마을 정보 add
		for (int i = 0; i <= N; i++)
			landInfo.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int startLand = Integer.parseInt(st.nextToken());
			int targetLand = Integer.parseInt(st.nextToken());
			int wasteTime = Integer.parseInt(st.nextToken());

			landInfo.get(startLand).add(new Land(targetLand, wasteTime));
		}

		// 그냥 가져오면 아래에서 값이 바뀌어버림
		int[] backDistnace = solution(X).clone();

		for (int i = 1; i <= N; i++) {
			if (i == X)
				continue;
			int[] goDistance = solution(i);
			answer = Math.max(answer, goDistance[X] + backDistnace[i]);
		}

		try {
			System.out.println(answer);
		} finally {
			bf.close();
		}

	}

	// 실제 다익스트라 알고리즘 시작
	public static int[] solution(int startLand) {
		PriorityQueue<Land> landQ = new PriorityQueue<>();

		Arrays.fill(dist, Integer.MAX_VALUE);

		// 시작지점
		dist[startLand] = 0;
		landQ.offer(new Land(startLand, 0));
		// 갔다가 다시 와야한다.

		// go target ->
		while (!landQ.isEmpty()) {
			Land cur = landQ.poll();
			int currentTargetLand = cur.targetLand;
			int currentWeight = cur.wasteTime;
			// 이미 최소 값이 적재 되어 있으면 skip

			if (dist[currentTargetLand] < currentWeight)
				continue;

			for (Land next : landInfo.get(currentTargetLand)) {
				// 거리 정보가 더 최소 경로라면
				if (dist[next.targetLand] > next.wasteTime + currentWeight) {
					dist[next.targetLand] = next.wasteTime + currentWeight;
					landQ.offer(new Land(next.targetLand, next.wasteTime + currentWeight));
				}
			}

		}
		return dist;
	}

	public static class Land implements Comparable<Land> {
		int targetLand;
		int wasteTime;

		Land(int targetLand, int wasteTime) {
			this.targetLand = targetLand;
			this.wasteTime = wasteTime;
		}

		public String toString() {
			return this.targetLand + " " + this.wasteTime;
		}

		@Override
		public int compareTo(Land o) {
			// 최소 가중치 정렬
			return this.wasteTime - o.wasteTime;
		}
	}

}
