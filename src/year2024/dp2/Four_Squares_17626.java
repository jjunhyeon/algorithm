package src.year2024.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Four_Squares_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int answer = 0;
        // 기본배열을 제곱수에 +1로 설정
        int len = (int)Math.sqrt(N) + 1;
        int[] array = new int[len];

        for(int i=0; i<len; i++){
            array[i] = i * i;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(N);
        visited.add(N);
        int total = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                if (num == 0) { // 바로 프로그램 종료
                    System.out.println(total);
                    return;
                }
                for (int n : array) {
                    if (n > num) break;
                    int nextNum = num - n;
                    if (!visited.contains(nextNum)) {
                        queue.offer(nextNum);
                        visited.add(nextNum);
                    }
                }
            }
            total++;
        }
        System.out.println(total);
    }
}
