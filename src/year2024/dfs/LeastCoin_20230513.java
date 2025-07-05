package src.year2024.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LeastCoin_20230513 {
    static Integer[] coinType;
    static int n = 0;
    static int restMoney = 0;
    static int answer = Integer.MAX_VALUE;
    static class Main {
        public void DFS(int L, int sum) {
                // sum이 target money보다 더 큰 경우도 볼 필요 없음
                if (sum > restMoney) {
                    return;
                }
                
                // answer보다 더 높은 depth에 대한 처리 필요 없음
                if(L >= answer){
                    return ;
                }

                // 깊이가 끝에 도달했다면
                if (sum == restMoney) {
                    answer = Math.min(answer,L);
                } else { // 그려나가기
                    for (int i = 0; i < n; i++) {
                    DFS(L + 1, sum + coinType[i]);
                }
            }
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        coinType = new Integer[n];
        for (int i = 0; i < n; i++) {
            coinType[i] = kb.nextInt();
        }
        Arrays.sort(coinType, Collections.reverseOrder());
        restMoney = kb.nextInt();
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
