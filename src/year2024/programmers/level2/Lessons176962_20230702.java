package year2024.programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 과제진행하기
 * */
public class Lessons176962_20230702 {
    public static class HomeWork implements Comparable<HomeWork> {
        private String subject;
        private int startTime;
        private int playTime;

        HomeWork(String subject, int startTime, int playTime) {
            this.subject = subject;
            this.startTime = startTime;
            this.playTime = playTime;
        }

        @Override
        public int compareTo(HomeWork o) {
            return this.startTime - o.startTime;
        }

        @Override
        public String toString() {
            return this.subject + " " + this.startTime + " " + this.playTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        input = input.substring(2, input.length() - 2);  // 첫 번째 '['와 마지막 ']' 제거
        input = input.replaceAll("\"", "");
        String[] part = input.split("\\], \\[");

        int rows = part.length;
        String[][] dataArray = new String[rows][];

        for (int i = 0; i < rows; i++) {
            String[] subParts = part[i].split(", ");
            dataArray[i] = subParts;
        }
        System.out.println(Arrays.toString(solution(dataArray)));
    }

    private static String[] solution(String[][] plans) {
        String[] answer = {};
        //과제를 끝낸 순서대로 이름을 배열에 담아 return
        //새로 시작한 과제 -> 중간에 멈춘 과제
        answer = new String[plans.length];
        PriorityQueue<HomeWork> pq = new PriorityQueue<>();

        for (int i = 0; i < plans.length; i++) {
            String[] taskInfo = plans[i];
            String subject = taskInfo[0];
            String times = taskInfo[1];
            int wasteTime = Integer.parseInt(taskInfo[2]);
            pq.add(new HomeWork(subject, getStartTime(times), wasteTime));
        }

        HomeWork work = pq.poll();
        // 처음 과제 시작 (가장빠른 시간으로 정렬 되어 있음)
        int now = work.startTime;
        // 멈춘 과제를 저장하기 위함
        Stack<HomeWork> stack = new Stack<>();
        // 정답 인덱스 처리 변수
        int num = 0;
        while (true) {
            if (!pq.isEmpty() && now + work.playTime > pq.peek().startTime) { // 다음 시작시간 이전이라면 과제 중지
                stack.push(new HomeWork(work.subject, work.startTime, work.playTime - (pq.peek().startTime - now)));
                now = pq.peek().startTime; // 다음 q의 시작시간으로 now 값 대체
                work = pq.poll(); //새로운 과제 시작
            } else {
                // 과제 끝남
                answer[num++] = work.subject; // 정답에 insert
                now += work.playTime;
                //새로 시작해야 하는 과제가 있다면 새로운 과제 시작
                if (!pq.isEmpty() && now == pq.peek().startTime) { // pq가 비어있지 않고 시간이 딱 맞아떨어질때
                    work = pq.poll();
                } else if (!stack.isEmpty()) { // stack 에 담긴 남은 과제 시작
                    //멈춰둔 과제 다시 시작
                    work = stack.pop();
                } else if (!pq.isEmpty()) { // stack 과제도 모두 끝냈다면 , pq에 남은 과제 처리
                    work = pq.poll();
                    now = work.startTime;
                } else break;
            }
        }
        return answer;
    }

    private static int getStartTime(String s) {
        String[] total = s.split(":");
        int hour = Integer.parseInt(total[0]) * 60;
        int time = Integer.parseInt(total[1]);
        return hour + time;
    }
}
