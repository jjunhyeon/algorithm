
import java.util.*;

/*
 * N과 M 9번째 시리즈
 * 백트레킹,DFS 문제
 * */
public class Main {

    static StringBuilder resultBuilder = new StringBuilder();
    static ArrayList<String> answerList = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int[] temp = new int[M];
        dfs(M, 0, arr, temp, visited);
        System.out.println(resultBuilder.toString());

    }

    public static void dfs(int targetLength, int depth, int[] arr, int[] temp, boolean[] visited) {

        // 목표길이때 처리한다.
        if (targetLength == depth) {
            StringBuilder st = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                if (i > 0) st.append(" ");  // 첫 번째 값 이후에는 공백 추가
                st.append(temp[i]);
            }
            if (!answerList.contains(st.toString())) {
                answerList.add(st.toString());
                resultBuilder.append(st);
                resultBuilder.append("\n");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp[depth] = arr[i];
            dfs(targetLength, depth + 1, arr, temp, visited);
            visited[i] = false;
        }

    }
}
