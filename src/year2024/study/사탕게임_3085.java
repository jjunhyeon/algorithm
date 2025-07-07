package year2024.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * packageName    : com.pass.boj.study
 * fileName       : 사탕게임_3085
 * author         : junhyeon
 * date           : 2024-05-12
 * description    : 사탕게임 [브루트포스]
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-12        junhyeon       최초 생성
 */
public class 사탕게임_3085 {
    static char[][] map;
    static int boardSize;

    public static void main(String[] args) throws IOException {

        int answer = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 처음 맵의 크기 정보를 입력값으로 받는다.
        boardSize = Integer.parseInt(bf.readLine());
        // 맵 크기 초기화
        map = new char[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            String param = bf.readLine();
            for (int j = 0; j < boardSize; j++) {
                map[i][j] = param.charAt(j);
            }
        }

        // 자리 바꾸기(행)
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                char[][] NewRowMap = changeValueEachByRow(i, j);

                answer = Math.max(answer, getMaxContinuousNumber(NewRowMap));
                char[][] NewColMap = changeValueEachByCol(i, j);
                answer = Math.max(answer, getMaxContinuousNumber(NewColMap));
            }
        }

        System.out.println(answer);
    }

    /* 자리 바꾸기, 행 기준 */
    private static char[][] changeValueEachByRow(int row, int col) {

        if (col + 1 == boardSize) {
            return null;
        }

        char[][] changedMap = new char[boardSize][boardSize];
        for(int i=0; i<boardSize; i++){
            changedMap[i] = Arrays.copyOf(map[i], boardSize);
        }

        char target = changedMap[row][col];
        // 복사 옆에 열과 값만 바꾸고 리턴
        changedMap[row][col] = changedMap[row][col + 1];
        changedMap[row][col + 1] = target;
        return changedMap;
    }

    /* 자리 바꾸기, 열 기준 */
    private static char[][] changeValueEachByCol(int col, int row) {

        if (row + 1 == boardSize) {
            return null;
        }
        // 기존 맵 값 복사
        char[][] changedMap = new char[boardSize][boardSize];
        for(int i=0; i<boardSize; i++){
            changedMap[i] = Arrays.copyOf(map[i], boardSize);
        }

        char target = changedMap[row][col];
        // 복사 옆에 행과 값만 바꾸고 리턴
        changedMap[row][col] = changedMap[row + 1][col];
        changedMap[row + 1][col] = target;
        return changedMap;
    }

    private static int getMaxContinuousNumber(char[][] newMap) {
        if (newMap == null) return 0;

        int answer = 0;

        // 행 비교
        for (int i = 0; i < boardSize; i++) {
            int maxRow = 1;
            for (int j = 1; j < boardSize; j++) {
                if (newMap[i][j - 1] == newMap[i][j]) {
                    maxRow++;
                } else {
                    maxRow = 1;
                }
                answer = Math.max(answer, maxRow);
            }
        }

        // 열 비교
        for (int i = 0; i < boardSize; i++) {
            int maxCol = 1;
            for (int j = 1; j < boardSize; j++) {
                if (newMap[j - 1][i] == newMap[j][i]) {
                    maxCol++;
                } else {
                    maxCol = 1;
                }
                answer = Math.max(answer, maxCol);
            }
        }

        return answer;
    }
}
