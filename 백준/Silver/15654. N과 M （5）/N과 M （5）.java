import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static int N,M;
    public static boolean[] visited;
    static int[] arr;
    public static StringBuilder sbResult = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = bf.readLine().split(" ");

        // N개의 자연수가 주어졌을때, 길이가 M인 수열을 모두 구하는 문제
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);

        int[] secondLine = new int[N];
        arr = new int[N];

        String[] inputNumbers = bf.readLine().split(" ");
        // 입력된 문자열을 정수로 변환하여 배열에 저장
        for (int i = 0; i < N; i++) {
            secondLine[i] = Integer.parseInt(inputNumbers[i]);
        }
        // 정렬
        Arrays.sort(secondLine);

        visited = new boolean[N];
        dfs(M,0,visited,secondLine);
        System.out.println(sbResult.toString());

    }

    public static void dfs(int end, int depth, boolean[] visited, int[] target){

        if(depth == end){
            for(int i=0; i<M; i++) {
                sbResult.append(arr[i]).append(" ");
            }
            sbResult.append("\n");
            return ;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i]= true;
            arr[depth] = target[i];
            dfs(end,depth+1,visited,target);
            visited[i] = false;
        }
    }
}
