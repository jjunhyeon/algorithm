package year2024.class4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 백준 - 벽 부수고 이동하기
 * */
public class Boj_벽부수고이동하기_2206 {
    static int row, col;
    // 비교를 위한 맵
    static int[][] map;

    static int[] xArray = {-1, 0, 1, 0};
    static int[] yArray = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        ArrayList<int[]> breakPoint = new ArrayList<>();
        int answer = Integer.MAX_VALUE;

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];

        // 1. 입력값 처리
        for (int i = 0; i < row; i++) {
            String row = bf.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
                // 1인 지점만 따로 저장
                if (map[i][j] == 1) breakPoint.add(new int[]{i, j});
            }
        }

        // 벽 안부순 결과
        answer = Math.min(bfs(0), answer);

        for (int[] item : breakPoint) {
            // 벽으로 바꾼다.
            map[item[0]][item[1]] = 0;
            int sum = bfs(0);
            answer = Math.min(sum, answer);
            // 다시 원복
            map[item[0]][item[1]] = 1;
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        bf.close();
    }

    // 0,0부터 N,M까지의 거리를 구하는 메소드 생성
    private static int bfs(int start) {
        Queue<int[]> bfsQ = new LinkedList<>();
        // 초기 시작지점 0,0
        bfsQ.offer(new int[]{0, 0});

        boolean[][] isVisited = new boolean[row][col];
        // 거리 정보 맵
        int[][] distanceInfo = new int[row][col];
        // 초기 방문정보, 초기 거리정보 업데이트
        isVisited[0][0] = true;
        distanceInfo[0][0] = 1;

        while (!bfsQ.isEmpty()) {
            int[] now = bfsQ.poll();

            int currentX = now[0];
            int currentY = now[1];
            for (int i = 0; i < 4; i++) {
                int movedX = currentX + xArray[i];
                int movedY = currentY + yArray[i];

                if (isCanMovePoint(movedX, movedY) && !isVisited[movedX][movedY]) {
                    isVisited[movedX][movedY] = true;
                    bfsQ.offer(new int[]{movedX, movedY});
                    distanceInfo[movedX][movedY] = distanceInfo[currentX][currentY] + 1;
                }
            }
        }

        // 최종 거리 정보 출력
        return (distanceInfo[row - 1][col - 1] == 0) ? Integer.MAX_VALUE : distanceInfo[row - 1][col - 1];
    }

    private static boolean isCanMovePoint(int x, int y) {
        if (x >= 0 && x < row && y >= 0 && y < col && map[x][y] == 0) return true;
        else return false;
    }
}
