package src.year2024.programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프로세스_42587 {

    public static void main(String[] args) {

        int[] priorities = {1, 1, 9, 1, 1};
        int location = 0;
        solution(priorities, location);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> myq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            myq.offer(priorities[i]);
        }

        while (!myq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == myq.peek()) {
                    myq.poll();
                    answer++;
                    if (i == location) return answer;
                }
            }
        }

        return answer;
    }
}
