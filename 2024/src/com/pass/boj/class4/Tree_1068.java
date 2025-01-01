import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree_1068 {
    static StringTokenizer st;
    static int N;
    static boolean visited[];
    static int deleteNum;
    static ArrayList<ArrayList<Integer>> answerList = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // NODE COUNT
        N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) answerList.add(new ArrayList<>());
        visited = new boolean[N];
        st = new StringTokenizer(bf.readLine());

        int root = -1;

        for (int i = 0; i < N; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            if (parentNode == -1) {
                root = i;
            } else {
                answerList.get(i).add(parentNode);
                answerList.get(parentNode).add(i);
            }
        }

        deleteNum = Integer.parseInt(bf.readLine());

        if (root == deleteNum) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(answer);
        }
    }

    private static void dfs(int start) {

        visited[start] = true;
        int count = 0;

        for (int cur : answerList.get(start)) {
            if (cur != deleteNum && !visited[cur]) {
                count++;
                dfs(cur);
            }
        }

        if (count == 0) answer++;
    }
}
