package year2024.programmers.level2;

import java.util.HashSet;
import java.util.Set;

/*
 * 연속 부분 수열
 * DFS
 * DFS -> Nc1 + Nc2 ... NcM 까지 처리 후
 * result 중복 제외 return
 * 시간초과 ????????
 * */
public class 연속부분수열합_131701 {

    static Set<Integer> answer = new HashSet<>();

    public static void main(String[] args) {

        int[] elements = new int[]{7, 9, 1, 1, 4, 2, 3, 5,6,7,12,31,24,123,12,4};

        boolean[] visited = new boolean[elements.length];
        for (int i = 1; i <= elements.length; i++) {
            int[] result = new int[i];
            dfs(elements, result, 0, 0, visited);
        }

        System.out.println("element" + answer);
    }

    public static void dfs(int[] elements, int[] result, int depth, int start, boolean[] visited) {
        if (result.length == depth) {
            int sum = 0;

            if (isContinuous(result, visited)) {
                int i = 0;
                while (i < result.length) {
                    sum += result[i];
                    i++;
                }
            }
            if (sum != 0) {
                answer.add(sum);
            }
            return;
        }
        // dfs
        for (int i = start; i < elements.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = elements[i];
                dfs(elements, result, depth + 1, i + 1, visited);
                visited[i] = false;
            }
        }
    }

    // 배열 내에서 target 배열이 연속된 값인지 확인하는 함수
    public static boolean isContinuous(int[] target,  boolean[] visited) {

        if (target.length == 1) {
            return true;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                // target 사이즈 만큼 확인하면 됨.
                int count = 0;
                int k = i;
                int reverse = (k - 1) < 0 ? visited.length - 1 : k - 1;
                while (visited[i] || visited[reverse]) {

                    if (k == visited.length) {
                        k = 0;
                    }

                    if (visited[k]) {
                        // 앞으로 탐색
                        k++;
                        count++;
                        if (count == target.length) {
                            return true;
                        }
                    } else if (visited[reverse]) { // 반대는 이어질떄
                        reverse--;
                        count++;
                        if (count == target.length) {
                            return true;
                        }
                    } else { // 둘다 아니면 찐 X
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
