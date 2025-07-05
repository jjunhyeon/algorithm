import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 수업시작과 끝
		// 초기 비어있는 Q에 CLASS를 하나 넣는다.
		// Q에 값이 담겨있을경우 현재 Q에 담긴 클래스와 다음 클래스를 비교한다.
		// 현재담긴 Q의 종료시간과 신규 클래스의 시작시간을 비교해서 만약 신규 클래스의 시작시간 >= 종료시간 일 경우
		// 지금 담겨 있는 Q를 POLL하고 신규 Q를 OFFER한다.
		// 만약 그렇지 않다면 Q에 그냥 OFFER한다.
		int classCount = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<ClassRoom> room = new PriorityQueue<ClassRoom>();
		for (int i = 0; i < classCount; i++) {
			st = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			room.offer(new ClassRoom(startTime, endTime));
		}
		// 종료 시간을 기준으로 우선 순위 큐를 생성
		PriorityQueue<ClassRoom> answer = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);
		answer.add(room.poll());
		while (!room.isEmpty()) {
			ClassRoom item = room.poll();
			if (answer.peek().endTime <= item.startTime) answer.poll();
			answer.offer(item);
		}
		System.out.println(answer.size());

	}

	static class ClassRoom implements Comparable<ClassRoom> {
		int startTime;
		int endTime;

		public ClassRoom(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(ClassRoom o) {
			return this.startTime - o.startTime;
		}
	}
}
