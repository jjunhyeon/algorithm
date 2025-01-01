package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 이중우선순위 큐
 * 시간초과 -> PriorityQueue 2개 사용(시간초과 발생)
 * */
public class DualPriorityQueue_7662_PriorityQueue_20230625 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tCases = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> minPi = new PriorityQueue<>();
        PriorityQueue<Integer> maxPi = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < tCases; i++) {
            int arrCount = Integer.parseInt(bf.readLine());
            maxPi.clear();
            minPi.clear();
            for (int j = 0; j < arrCount; j++) {
                String[] arg = bf.readLine().split(" ");
                String type = arg[0];
                int num = Integer.parseInt(arg[1]);
                if (type.equals("I")) {
                    minPi.offer(num);
                    maxPi.offer(num);
                } else if (!minPi.isEmpty() && type.equals("D") && num == -1) { // 최솟값 삭제
                    int t = minPi.poll();
                    maxPi.remove(t);
                } else if (!maxPi.isEmpty() && type.equals("D") && num == 1) {  // 최대값 삭제
                    int t = maxPi.poll();
                    minPi.remove(t);
                }
            }
            if (minPi.isEmpty() || maxPi.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(maxPi.peek() + " " + minPi.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
