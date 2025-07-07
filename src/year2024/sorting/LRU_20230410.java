package year2024.sorting;

import java.util.Scanner;

/*
 * 캐시 메모리
 * LRU(Least Recently Used)가장 최근에 사용하지 않을것을 제거하는 알고리즘을 사용한다
 *
 * 1. Catch miss
 * 해야할 작업이 캐시에 없는 상태로 새로운 작업을 사용한다면 모든 작업이 뒤로 밀리고 5번 작업은 캐시의 맨 앞에 위치하게 된다.
 *
 * 2. Cache Hit
 * 해야할 작업이 캐시에 있는 상태로 위상태에서 Cache Hit가 되고 새로 들어온 작업의 번호가 가장 앞으로 오며 그 이전 숫자가 한칸씩 밀리게 된다.
 * */
//FIXME 다시 풀어야할 문제
public class LRU_20230410 {
    // 실제 Solution
    static class Main {
        public String solution(int m, int n, int[] array) {
            String answer = "";
            int[] result = new int[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0 && result.length > 1) {
                        int num = j;
                        Boolean isExistSameNum = false;
                        // result에 신규로 들어온 array[j]가 있는지 검사해야함
                        for (int k = 0; k < result.length; k++) {
                            if (result[k] == array[j]) {
                                // result안에 같은 값이 존재할 시
                                while (k > 0) {
                                    result[k] = result[k - 1];
                                    isExistSameNum = true;
                                    k--;
                                }
                            }
                        }
                        if (num > 0 && !isExistSameNum) {
                            // 존재하지 않는다면 아레 while문 처리
                            if (num > result.length) {
                                num = result.length - 1;
                            }
                            while (num >= 1) {
                                result[num] = result[num - 1];
                                num--;
                            }
                        }
                    }
                    result[0] = array[j];
                }
            }
            for (int z = 0; z < result.length; z++) {
                answer += result[z] + " ";
            }

            return answer;
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int m = kb.nextInt();
        int n = kb.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = kb.nextInt();
        }
        System.out.println((T.solution(m, n, array)));
    }
}
