package year2024.class4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 스티커 - dp 문제
 * https://m.blog.naver.com/occidere/220786307316 참조
 * */
public class 스티커_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            int col = Integer.parseInt(bf.readLine());
            int[][] stickerArray = new int[2][col+1];
            int[][] answerArray = new int[2][col+1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 1; j <= col; j++) {
                    stickerArray[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기값 세팅
            answerArray[0][1] = stickerArray[0][1];
            answerArray[1][1] = stickerArray[1][1];

            //점화식
            for(int i=2; i<=col; i++){
                answerArray[0][i] = Math.max(answerArray[1][i-1],answerArray[1][i-2]) + stickerArray[0][i];
                answerArray[1][i] = Math.max(answerArray[0][i-1],answerArray[0][i-2]) + stickerArray[1][i];
            }

            System.out.println(Math.max(answerArray[0][col],answerArray[1][col]));
        }
    }
}
