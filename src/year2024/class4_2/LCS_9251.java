package src.year2024.class4_2;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * 백준 - 최장 부분 순열
 * LCS(Longest Common Subsequence, 최장 공통 부분 순열)
 * */
public class LCS_9251 {

    public static String firstString;
    public static String secondString;
    public static int max = 0;
    //public static HashMap<Integer, List<String>> resultMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        firstString = bf.readLine();
        secondString = bf.readLine();
        if (firstString.equals(secondString)) {
            System.out.println(firstString.length());
        } else {

            String newFirstString = " " + firstString;
            String newSecondString = " " + secondString;

            int newFirstStringSize = newFirstString.length();
            int newSecondStringSize = newSecondString.length();

            int[][] lcsMatrix = new int[newFirstStringSize][newSecondStringSize];
            for (int i = 1; i < newFirstStringSize; i++) {
                for (int j = 1; j < newSecondStringSize; j++) {
                     if (newFirstString.charAt(i) == newSecondString.charAt(j)) {
                        lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                    } else {
                        lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
                    }
                }
            }

            System.out.println(lcsMatrix[newFirstStringSize-1][newSecondStringSize-1]);

//            StringBuilder sb = new StringBuilder();
//            int row = newFirstStringSize - 1;
//            int col = newSecondStringSize - 1;
//            while (lcsMatrix[row][col] != 0) {
//                if (lcsMatrix[row][col] == lcsMatrix[row - 1][col]) {
//                    row--;
//                } else if (lcsMatrix[row][col] == lcsMatrix[row][col - 1]) {
//                    col--;
//                } else {
//                    sb.append(newFirstString.charAt(row));
//                    row--;
//                    col--;
//                }
//            }
//             최장부분수열 문자까지 찾기
//            System.out.println("sb::" + sb.reverse());

        }
    }

    /*
     * dfs -> 백트레킹 시간초과
     * */
//    private static void dfs(String type, int start, String baseString, int depth, int end, StringBuilder sb, boolean[] visited) {
//
//        int len = baseString.length();
//        // 길이별 add
//        if (depth == end) {
//            if (type.equals("second")) {
//                if (resultMap.get(end).contains(sb.toString())) {
//                    max = Math.max(sb.length(), max);
//                }
//            }
//
//            if (!resultMap.get(end).contains(sb.toString())) {
//                resultMap.get(end).add(sb.toString());
//            }
//
//            return;
//        }
//
//        for (int i = start; i < len; i++) {
//
//            if (visited[depth]) continue;
//
//            sb.append(baseString.charAt(i));
//            visited[depth] = true;
//            dfs(type, i + 1, baseString, depth + 1, end, sb, visited);
//            visited[depth] = false;
//            sb.deleteCharAt(sb.length() - 1);
//
//        }
//
//    }
}
