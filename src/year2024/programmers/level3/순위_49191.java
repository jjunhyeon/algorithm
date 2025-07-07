package year2024.programmers.level3;

/*
 * 순위
 * 플로이드 와샬 알고리즘
 *
 * */
public class 순위_49191 {

    public static void main(String[] args) {

        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        Integer[][] answer = new Integer[n + 1][n + 1];

        // answer 배열을 모두 null로 초기화
        // 대진표 생성 1->1 은 0 , 승관계 1, 패배관계 -1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = null;
                }
            }
        }

        for (int k = 0; k < results.length; k++) {
            int[] arr = results[k];
            int winner = arr[0];
            int loser = arr[1];
            answer[winner][loser] = 1;
            answer[loser][winner] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // 1번이 2번을 이기고
                    // 2번이 5번을 이긴다면
                    // 1번은 5번을 이긴다
                    if (answer[j][i] == null || answer[i][k] == null) continue;

                    if (answer[j][i] == 1 && answer[i][k] == 1) {
                        // 1번은 5번을 이긴다
                        answer[j][k] = 1;
                        answer[k][j] = -1;
                    }
                }
            }
        }

        int result = n;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (answer[i][j] == null) {
                    result--;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
