import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
int result = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {

            if(n < 0){
                result = i - 1;
                return result;
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
                        int maxValue = pq.poll();
                        n += maxValue;
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