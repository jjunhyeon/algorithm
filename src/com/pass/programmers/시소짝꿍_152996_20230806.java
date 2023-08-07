package com.pass.programmers;

import java.util.Arrays;

/*
 *
 * 시소짝궁
 * dfs 조합
 * */
public class 시소짝꿍_152996_20230806 {

    static int dfsAnswer = 0;

    public static void main(String[] args) {
        int[] weight = {100, 180, 360, 100, 270};
        solution(weight);
    }

    public static int solution(int[] weight) {
        Arrays.sort(weight);
        long[] result = new long[2];
        boolean[] visited = new boolean[weight.length];
        DFS(weight, result, 0, 0, 2, visited);
        int answer= 0;
        
        /*
        * 이중포문 썼는데 비효율
        * */
        for (int i = 0; i < weight.length; i++) {
            for (int j = i + 1; j < weight.length; j++) {
                if((weight[i] * 2) < weight[j]){
                    break;
                }
                if (weight[i] == weight[j]) {
                    answer++;
                }  else if (2 * weight[j] == 3 * weight[i]){
                    answer ++;
                } else if(2 * weight[j] == 4 * weight[i]){
                    answer ++;
                } else if(3 * weight[j] == 4 * weight[i]) {
                    answer++;
                }
            }
        }
        return answer;
    }

    /*
     * @param weight : 무게
     * @param result : dfs 결과
     * @param depth : 깊이
     * @param r : 깊이의 조건
     * @param visited : 방문여부
     * dfs -> 실패(시간초과 문제) ...
     * 검증 케이스 추가로 할 수 있을지도?
     * */
    public static void DFS(int[] weight, long[] result, int start, int depth, int r, boolean[] visited) {

        if (depth == r) {
            long lt = result[0];
            long rt = result[1];

            if (lt == rt) { // 값이 같은 경우
                dfsAnswer++;
            } else if (lt > rt) {// lt 가 더 큰 경우
                if (2 * lt == 3 * rt || 2 * lt == 4 * rt || 3 * lt == 4 * rt) {
                    dfsAnswer++;
                }
            } else if (lt < rt) {  // rt가 더 큰 경우
                if (2 * rt == 3 * lt || 2 * rt == 4 * lt || 3 * rt == 4 * lt) {
                    dfsAnswer++;
                }
            }
            return;
        }

        for (int i = start; i < weight.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = weight[i];

                DFS(weight, result, i + 1, depth + 1, r, visited);
                visited[i] = false;
            }
        }
    }
}
