package year2024.programmers.level2;

import java.util.Arrays;

/*
 *
 * 시소짝궁
 * dfs 실패 케이스 (TLE : Time Limit Exceeded)
 * */
public class 시소짝꿍_152996_20230806_DFS {

    static int answer = 0;

    public static void main(String[] args) {
        int[] weight = {100, 180, 360, 100, 270};
        solution(weight);
    }

    public static int solution(int[] weight) {
        Arrays.sort(weight);
        long[] result = new long[2];
        boolean[] visited = new boolean[weight.length];
        DFS(weight, result, 0, 0, 2, visited);
        return answer;
    }

    /*
     * @param weight : 무게
     * @param result : dfs 결과
     * @param depth : 깊이
     * @param r : 깊이의 조건
     * @param visited : 방문여부
     * dfs -> 실패(시간초과)
     * */
    public static void DFS(int[] weight, long[] result, int start, int depth, int r, boolean[] visited) {

        if (depth == r) {
            long lt = result[0];
            long rt = result[1];
            // Arrays.sort를 적용했기 때문에 나오는 조합의 케이스는 lt < rt 케이스만 고려한다.
            if(lt * 2 < rt){
                return ;
            } else if(lt == rt){
                answer ++;
            } else if(3 * lt == 2 * rt){
                answer ++;
            } else if(4 * lt == 3 * rt){
                answer ++;
            } else if(4 * lt == 2 * rt) {
                answer ++;
            }
            return ;
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
