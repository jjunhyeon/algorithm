package study;

import java.io.*;
import java.util.*;

/**
 * 프린터
 * 우선순위 큐
 */
public class 프린터_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 문제의 수
        int solveCount = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        while (solveCount-- > 0) {
            st = new StringTokenizer(bf.readLine());
            // 배열의 수
            int arrayCount = Integer.parseInt(st.nextToken());
            // 타겟 배열
            int targetIndex = Integer.parseInt(st.nextToken());
            int[] array = new int[arrayCount];
            Queue<int[]> Q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < arrayCount; i++) {
                // 비교를 위해 array와 pq에 동일한 값을 담는다.
                array[i] = Integer.parseInt(st.nextToken());
                // 순서와 값 정보를 담게한다.
                // pq의 정렬 우선순위는 값이지만
                // int[0]은 순서, int[1]은 값
                pq.offer(array[i]);
                Q.offer(new int[]{i, array[i]});
            }

            int answerIdx = 0;

            while (!Q.isEmpty()) {
                int[] current = Q.poll();
                // 현재 큐의 값과 우선순위 큐의 값이 일치할 경우
                if (!pq.isEmpty() && current[1] == pq.peek()) {
                    pq.poll();
                    answerIdx++;
                    // 값이 타겟과 일치하고 순서가 일치한다면 끝
                    if (current[0] == targetIndex) {
                        break;
                    }
                } else {
                    // q에는 다시 넣어준다.
                    Q.offer(current);
                }
            }
            bw.append(Integer.toString(answerIdx)).append("\n");
        }
        bf.close();
        bw.close();
    }
}
