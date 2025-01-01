package class4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_최단거리_1916 {

	public static class Bus implements Comparable<Bus> {
		// 도차기 정보
		int arrivalLand;
		// 소요시간
		int time;

		Bus(int arrivalLand, int time) {
			this.arrivalLand = arrivalLand;
			this.time = time;
		}

		@Override
		public int compareTo(Bus o) {
			// 시간 순서로 reverse 정렬 조건 추가
			// 거리가 작은 녀석이 먼저 정렬될 수 있도록
			return this.time - o.time;
		}
	}

	public static ArrayList<ArrayList<Bus>> busInfo = new ArrayList<>();
	public static int[] dist;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int LoadNum = Integer.parseInt(st.nextToken());

		// 마을간 거리 정보
		dist = new int[LoadNum + 1];
		for (int i = 0; i < LoadNum + 1; i++)
			busInfo.add(new ArrayList<>());

		st = new StringTokenizer(bf.readLine());
		int len = Integer.parseInt(st.nextToken());

		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(bf.readLine());

			int startLand = Integer.parseInt(st.nextToken());
			int arrivalLand = Integer.parseInt(st.nextToken());
			int wasteTime = Integer.parseInt(st.nextToken());
			busInfo.get(startLand).add(new Bus(arrivalLand, wasteTime));
		}

		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);
		// to get end Array calculate get answer ;
		System.out.println(dist[end]);
		
		
	}

	private static void dijkstra(int start) {

		PriorityQueue<Bus> busQ = new PriorityQueue<Bus>();

		// 시작지점과 wasteTime은 0으로 하나 offer
		busQ.offer(new Bus(start, 0));

		Arrays.fill(dist, Integer.MAX_VALUE);
		// 시작지점은 당연히 0이겠죠
		dist[start] = 0;

		while (!busQ.isEmpty()) {

			Bus nowQ = busQ.poll();

			int nowTime = nowQ.time;
			int nowLand = nowQ.arrivalLand;

			// 이미 최종 거리 구한 정보가 이제 탐색할 정보보다 작다면 아래를 탐색할 필요가 없음
			if (dist[nowLand] < nowTime)
				continue;
			// 시작지적이 가르키는 방향부터 탐색한다.
			// ex : 1 -> 4 , 1 -> 5 => [4,5] 의 dist add
			for (Bus item : busInfo.get(nowLand)) {

				// 구하고자 하는 정보
				// start 지점이 가리키는 거리보다 현재 까지의 거리 + 다음 거리가 더 작다면
				if (dist[item.arrivalLand] > nowTime + item.time) {
					// 정보 업뎃
					dist[item.arrivalLand] = nowTime + item.time;
					// 탐색할 다음 마을 정보와 누적 거리 정보로 업데이트
					busQ.offer(new Bus(item.arrivalLand, nowTime + item.time));
				}
			}
		}

	}
}
