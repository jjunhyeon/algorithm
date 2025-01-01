package programmers.level2;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *  후보키
 *  릴레이션의 튜플을 유이할게 식별할 수 있는 속성 또는 속성의 집합 중 다음 두 성질을 만족하는 것을 후보키라고 한다.
 *  유일성 : 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다.
 *  최소성 : 유일성을 가진 키를 구성하는 속성 중 하나라도 제외하는 경우 유일성이 깨지는 경우를 의미한다. 즉 릴레이션의 모든 튜플을 유일하게 식별하는 데 꼭 필요한
 *  속성들로만 구성되어야 한다.
 *
 *  문제의 요구사항 : 릴레이션에서 후보키의 개수를 리턴하라.
 *
 *  dfs -> 모든 조건 탐색한다.
 *
 *  한 컬럼의 모든 데이터가 유일하다면 정답 +1
 *  한 컬럼의 데이터에 중복이 있을 경우, 다음 탐색을 해야할 컬럼으로 남겨둔다.
 *  1차 필터링한 컬럼을 제외하고 남은 컬럼끼리 2개씩 묶어서 묶었을대는 모든 데이터가 유일한지 확인한다.
 *  유일하다면 2차 필터 데이터로 남기며 스킵하고
 *  그렇지 않을경우 다음 탐색을 해야할 컬럼 정보로 남겨둔다....
 *  결국 최종은 중복된 컬럼 정보가 있는 하나의 컬럼이 남을때까지.
 * */
public class 후보키_43890 {

    static String[][] database;
    static List<String> answer = new ArrayList<>();
    static int rowSize;
    static int relationSize;

    public static void main(String[] args) {
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        solution(relation);
    }

    private static int solution(String[][] relation) {
        database = relation;
        relationSize = relation.length;
        rowSize = relation[0].length;
        for (int i = 0; i < rowSize; i++) {
            boolean[] visited = new boolean[rowSize];
            dfs(visited, 0, 0, i + 1);
        }
        return answer.size();
    }

    /*
     * dfs 탐색
     * 유일성과 최소성을 고려
     * */
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
                for (int i = 0; i < target.length(); i++) {
                    String s = String.valueOf(target.charAt(i));
                    if (ans.contains(s)) count++;
                }

                // 만약 인덱스번호 13이 들어가 있을경우, target에 담긴 idx는 123일 경우 같은 값 1,3 길이는 2 이므로 후보키 X
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
