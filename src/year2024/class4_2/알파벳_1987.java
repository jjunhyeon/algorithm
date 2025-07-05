package src.year2024.class4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알파벳_1987 {

    public static int row, col;
    public static String[][] map;

    public static int[] xArray = {-1, 0, 1, 0};
    public static int[] yArray = {0, 1, 0, -1};
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 첫 줄에 가로, 세로 정보
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        // String map
        map = new String[row][col];

        for (int i = 0; i < row; i++) {
            String row = bf.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = String.valueOf(row.charAt(j));
            }
        }

        dfs(new int[]{0, 0}, new HashSet<>());
        System.out.println(answer);
    }

    private static void dfs(int[] current, Set<String> resultSet) {

        int currentX = current[0];
        int currentY = current[1];

        if (!(currentX >= 0 && currentY >= 0 && currentX < row && currentY < col && !resultSet.contains(map[currentX][currentY]))) {
            answer = Math.max(answer, resultSet.size());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int movedX = currentX + xArray[i];
            int movedY = currentY + yArray[i];
            // 정상값의 범위 + 움직이는 지점에 존재하는 String이 resultSet에 존재하지 않으면 go
            // 큐 ADD
            // 거리 정보 추가
            // resultSet add
            resultSet.add(map[currentX][currentY]);
            dfs(new int[]{movedX, movedY}, resultSet);
            resultSet.remove(map[currentX][currentY]);
        }
    }
}
