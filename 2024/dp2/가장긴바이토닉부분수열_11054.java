package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
* 6
  1 4 3 2 5 1
 -> 5
 *
 * 10
1 5 2 1 4 3 4 5 2 1
* -> 7
*
* 2
* 2 1
* -> 2
*
* 10
  10 1 3 5 7 6 3 2 1 10
  * 8
 *
* */
public class 가장긴바이토닉부분수열_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] array = new int[N];
        // 현재까지의 최대값의 범위를 지정
        int[] leftStartDp = new int[N];
        int[] rightStartDp = new int[N];

        // 값 할당
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽 최대 증가 배열 값 세팅
        for (int i = 0; i < N; i++) {
            leftStartDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    leftStartDp[i] = Math.max(leftStartDp[i], leftStartDp[j] + 1);
                }
            }
        }

        // 오른쪽 최대 증가 배열 값 세팅
        for (int i = N - 1; i >= 0; i--) {
            rightStartDp[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (array[i] > array[j]) {
                    rightStartDp[i] = Math.max(rightStartDp[i], rightStartDp[j] + 1);
                }
            }
        }

        int answer = 0;
        // 각 위치에서의 증가하는 부분 수열과 감소하는 부분 수열의 길이 합산
        for (int i = 0; i < N; i++) {
            // 중복된 위치를 고려하여 -1
            answer = Math.max(answer, leftStartDp[i] + rightStartDp[i] - 1);
        }

        System.out.println(answer);
    }
}

