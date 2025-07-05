

import java.util.*;
class Solution {
    
    static String[][] database;
    static List<String> answer = new ArrayList<>();
    static int rowSize;
    static int relationSize;
    public int solution(String[][] relation) {
        database = relation;
        relationSize = relation.length;
        rowSize = relation[0].length;
        for (int i = 0; i < rowSize; i++) {
            boolean[] visited = new boolean[rowSize];
            dfs(visited, 0, 0, i + 1);
        }
        return answer.size();
    }
    
    public static void dfs(boolean[] visited, int start, int depth, int end) {

        // 깊이와 end 탐색 지점이 같았을떄 순회시작
        if (depth == end) {
            // idx -> 현재 탐색하는 col 정보
            List<Integer> idxList = new ArrayList<>();
            StringBuilder target = new StringBuilder();
            for (int i = 0; i < rowSize; i++) {
                // ture target을 탐색한다.
                if (visited[i]) {
                    // 탐색할 idx 정보가 list에 담김.
                    target.append(i);
                    idxList.add(i);
                }
            }

            // 전체 탐색
            Set<String> answerSet = new HashSet<>();
            for (int i = 0; i < relationSize; i++) {

                StringBuilder sb = new StringBuilder();
                for (Integer idx : idxList) {
                    sb.append(database[i][idx]);
                }

                // 이미 포함되어 있으면 유일성 깨짐
                if (answerSet.contains(sb.toString())) {
                    return;
                } else {
                    answerSet.add(sb.toString());
                }
            }

            for (String ans : answer) {
                int count = 0;

                // 최소성 확인해야함
                // 만약 인덱스번호 123이 들어가 있을경우, target에 담긴 idx는 13이라면  -> 후보키 X
                for (int i = 0; i < target.length(); i++) {
                    String s = String.valueOf(target.charAt(i));
                    if (ans.contains(s)) count++;
                }

                if (count == ans.length()) return;
            }
            // 최소성을 만족하는지 확인해야함
            answer.add(target.toString());
        }


        for (int i = start; i < rowSize; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // 깊이만 하나 증가시키면서 dfs 탐색 시작한다.
                dfs(visited, i, depth + 1, end);
                visited[i] = false;
            }
        }
    }
}