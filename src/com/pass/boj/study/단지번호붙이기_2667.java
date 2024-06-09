package com.pass.boj.study;

import java.io.*;
import java.util.*;

/**
 * 단지번호붙이기
 * bfs
 */
public class 단지번호붙이기_2667 {
    static int MAP_SIZE;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static TreeMap<Integer, Integer> answerMap = new TreeMap<>();
    static int[] xArray = {-1, 0, 1, 0};
    static int[] yArray = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MAP_SIZE = Integer.parseInt(bf.readLine());
        map = new int[MAP_SIZE][MAP_SIZE];
        copyMap = new int[MAP_SIZE][MAP_SIZE];
        visited = new boolean[MAP_SIZE][MAP_SIZE];
        answerMap = new TreeMap<>();
        for (int i = 0; i < MAP_SIZE; i++) {
            String row = bf.readLine();
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        int idx = 1;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                // 미방문 && 집
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j, idx);
                    idx++;
                }
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(answerMap.entrySet());
        list.sort(Map.Entry.comparingByValue());

        // 정렬된 결과를 LinkedHashMap에 삽입
        Map<Integer, Integer> sortedByValueMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedByValueMap.put(entry.getKey(), entry.getValue());
        }

        bw.append(Integer.toString(idx-1)).append("\n");
        for (Map.Entry<Integer, Integer> entry : sortedByValueMap.entrySet()) {
            bw.append(Integer.toString(entry.getValue())).append("\n");
        }

        bf.close();
        bw.flush();

        bw.close();
    }

    /*
     * 실제 bfs 수행
     * */
    private static void bfs(int startRow, int startCol, int idx) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startRow, startCol});

        copyMap[startRow][startCol] = idx;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int movedX = curX + xArray[i];
                int movedY = curY + yArray[i];
                // 정상범위 + 미방문 + 집 체크
                if (movedX >= 0 && movedX < MAP_SIZE && movedY >= 0 && movedY < MAP_SIZE && !visited[movedX][movedY] && map[movedX][movedY] == 1) {
                    copyMap[movedX][movedY] = idx;
                    visited[movedX][movedY] = true;
                    q.offer(new int[]{movedX, movedY});
                    answerMap.put(idx, answerMap.getOrDefault(idx, 0) + 1);
                }
            }
        }

        if(!answerMap.containsKey(idx)) answerMap.put(idx, 1);
    }
}
