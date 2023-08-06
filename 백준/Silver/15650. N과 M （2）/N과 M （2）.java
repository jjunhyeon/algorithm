
import java.io.*;

public class Main{
    static int[] result;
    static int N,M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndm = bf.readLine().split(" ");
        N = Integer.parseInt(nAndm[0]);
        M = Integer.parseInt(nAndm[1]);

        result = new int[M];
        visited = new boolean[N];
        solution(0, 0);
    }

    public static void solution(int start, int depth) {

        if (depth == M) {
            // 출력 조건
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }


        for (int i = start; i < N; i++) {
            // 방문하지 않았따면
            if(!visited[i]){
                visited[i] = true;
                result[depth] = i+1;
                solution(i + 1, depth + 1);
                visited[i] = false;
            }
        }

    }
}
