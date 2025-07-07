package year2024.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 이분탐색
 * */
public class 나무자르기_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // N 나무의 수
        int N = Integer.parseInt(st.nextToken());

        // 최소 목표 나무의 수
        int T = Integer.parseInt(st.nextToken());

        int[] treeArray = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            treeArray[i] = Integer.parseInt(st.nextToken());
        }

        // 갑 정렬
        Arrays.sort(treeArray);

        long left = 0;
        long right = treeArray[N - 1];
        long height;

        while (left < right) {
            long result = 0;
            height = (left + right) / 2;

            for (int i = 0; i < N; i++) {
                long temp = treeArray[i] - height;
                result += (temp > 0) ? temp : 0;
            }

            /*
             * 자른 나무의 길이의 합이 T보다 작다는것은
             * 자르는 위치가 높다는 것을 의미하므로
             * 높이를 낮춰야한다.
             * 상한을 줄여야한다.
             * */
            if (result < T) {
                right = height;
            } else {
                /*
                 * 자른 나무의 길이의 합이 T 보다 작다는것은
                 * 자르는 위치가 낮다는 것을 의미하므로
                 * 자르는 위치를 높여야한다.
                 * 상한를 줄여야 한다.
                 * 상한을 줄이기 위해선
                 * LEFT의 값을 목표 높이보다 크게하면 상한이 줄어들고 가져가는 나무의 수를 줄일 수 있다.
                 * */
                left = height + 1;
            }
        }

        System.out.println(left - 1);
        bf.close();
    }
}
