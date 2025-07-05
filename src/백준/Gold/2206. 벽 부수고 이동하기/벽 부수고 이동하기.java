import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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

        answer = bfs(0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        bf.close();
    }

    // 0,0부터 N,M까지의 거리를 구하는 메소드 생성
    private static int bfs(int start) {
        Queue<int[]> bfsQ = new LinkedList<>();
        // 초기 시작지점 0,0
        bfsQ.offer(new int[]{0, 0, 0});

        // visited 부분에 방문여부를 처리할 수 있게 3차원으로 처리한다.
        boolean[][][] isVisited = new boolean[row][col][2];
        // 거리 정보 맵
        int[][][] distanceInfo = new int[row][col][2];
        // 초기 방문정보, 초기 거리정보 업데이트
        isVisited[0][0][0] = true;
        distanceInfo[0][0][0] = 1;

        while (!bfsQ.isEmpty()) {
            int[] now = bfsQ.poll();

            int currentX = now[0];
            int currentY = now[1];
            int currentBreak = now[2];

            if (currentX == row - 1 && currentY == col - 1 ) return distanceInfo[currentX][currentY][currentBreak];

            for (int i = 0; i < 4; i++) {
                int movedX = currentX + xArray[i];
                int movedY = currentY + yArray[i];
                int nextBreak = currentBreak;
                
                if (isCanMovePoint(movedX, movedY)) {

                    if(isVisited[movedX][movedY][currentBreak]) continue;
                    
                    isVisited[movedX][movedY][currentBreak] = true;
                    
                    if (map[movedX][movedY] == 0) {
                        distanceInfo[movedX][movedY][nextBreak] = distanceInfo[currentX][currentY][currentBreak] + 1;
                        bfsQ.offer(new int[]{movedX, movedY, currentBreak});
                    }

                    // 근처가 벽이고 아직 벽 안부셨으면
                    if (map[movedX][movedY] == 1 && nextBreak == 0) {
                        distanceInfo[movedX][movedY][1] = distanceInfo[currentX][currentY][currentBreak] + 1;
                        nextBreak = 1;
                        bfsQ.offer(new int[]{movedX, movedY, nextBreak});
                    }

                }
            }
        }
        // 최종 거리 정보 출력
        return -1;
    }

    private static boolean isCanMovePoint(int x, int y) {
        if (x >= 0 && x < row && y >= 0 && y < col) return true;
        else return false;
    }
}
