package class4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M8_15667 {

    public static int N,L;
    public static int[] array;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        array =new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) array[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(array);
        int[] resultArray = new int[L];

        dfs(0,resultArray,0);
        System.out.println(sb);
    }

    static void dfs(int depth, int[] result,int target){

        if(depth == L){
            for(int i=0; i<L; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }

        for(int i=0; i<N; i++){
            if(target <= array[i]){
                result[depth] = array[i];
                dfs(depth +1 , result, array[i]);
            }
        }

    }
}
