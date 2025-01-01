package programmers.level2;


import java.util.Collections;
import java.util.PriorityQueue;

/*
 *
 * 디펜스게임
 * */
public class 디펜스게임_142085 {
    public static void main(String[] args) {
/*        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        int n = 7;
        int k = 3;*/
/*        int n =2;
        int k =4;
        int[] enemy = {3, 3, 3, 3};*/
        int n = 3;
        int k = 0;
        int[] enemy = {3, 4};
        int answer = solution(n, k, enemy);
        System.out.println(answer);
    }

    /*
     * n -> 병사의수
     * k -> 방어권
     * enemy -> 적
     * */
    public static int solution(int n, int k, int[] enemy) {
        int result = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            if (n < 0) {
                return i - 1;
            }
            n -= enemy[i];
            pq.offer(enemy[i]);
            // 생존한 병사가 없을때
            if (n < 0) {
                // 가장 큰 값부터 원복
                while (!pq.isEmpty()) {
                    if (k > 0) {
                        // 방어권 1차감
                        k -= 1;
                        n += pq.poll();
                        if (n >= 0) {
                            break;
                        }
                    } else {
                        result = i;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
