package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실_1374 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int CLASS_COUNT = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		PriorityQueue<ClassRoom> PQ = new PriorityQueue<>((o1, o2) ->  o1.startTime == o2.startTime ? o1.endTime - o2.endTime : o1.startTime - o2.startTime);
		PriorityQueue<Integer> endTimeQ = new PriorityQueue<Integer>();
		
		for(int i=0; i<CLASS_COUNT; i++) {
			st = new StringTokenizer(bf.readLine());
			int classIdx = Integer.parseInt(st.nextToken());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			endTimeQ.offer(endTime);
			PQ.offer(new ClassRoom(classIdx,startTime,endTime));	
		}
		
		while(!PQ.isEmpty()) {
			// 강의의 시작시간이 종료시간보다 큰 부분을 찾는다.
			ClassRoom currentClass = PQ.poll();
			// 현재 강의 종료시간보다 시작시간이 더 크다면 끝난방에서 낭비없이 강의를 할 수 있다.
			if(!endTimeQ.isEmpty() && currentClass.startTime >=endTimeQ.peek()) endTimeQ.poll();
		}
		System.out.println(endTimeQ.size());
	}
 }

class ClassRoom {
	int classIdx;
	int startTime;
	int endTime;
	ClassRoom(int classIdx, int startTime, int endTime){
		this.classIdx = classIdx;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return classIdx + " " + startTime + " " + endTime;
	}
}
