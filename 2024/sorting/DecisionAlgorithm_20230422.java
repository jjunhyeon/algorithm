package sorting;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 결정알고리즘
 * : 답을 찾는 방법
 * : 뮤직비디오(결정알고리즘)
 * : 최소한의 DVD 용량의 크기를 찾는 문제
 *
 * */
public class DecisionAlgorithm_20230422 {
    // 실제 Solution
    static class Main {
        public int solution(int m, int[] array) {
            int answer = 0;
            // 이분 검색
            // stream 내부 메소드 arr의 max값과 sum값 제공
            int lt = Arrays.stream(array).max().getAsInt();
            int rt = Arrays.stream(array).sum();

            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                // 정답을 찾음 -> 0부터 시작 +1 값을 최종 답 리턴
                if (m >= count(array, mid)) {
                    answer = mid;
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
            return answer;
        }

        public int count(int[] arr, int capacity) {
            int count = 0;
            int tmp = 0;
            for (int i = 0; i < arr.length; i++) {
                // 용량보다 tmp가 커진다면 그때 count를 증가시키고 tmp를 새로운 arr[i]값으로 대체한다
                if (capacity < tmp + arr[i]) {
                    count++;
                    tmp = arr[i];
                } else {
                    // 계속 tmp에 arr[i]값을 누적시킨다.
                    tmp += arr[i];
                }
            }
            // arr[i]의 마지막값은 처리가 되지 않으므로 정상적인 케이스에 대해선 +1을 해준다.
            return (arr.length == 0) ? 0 : count + 1;
        }
    }

    /*
     * 값 입력받기
     * */
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = kb.nextInt();
        }
        System.out.println((T.solution(m, array)));
    }
}
