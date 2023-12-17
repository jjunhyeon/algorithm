import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 이분탐색
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // N 나무의 수
        int N = Integer.parseInt(st.nextToken());
        
        // 최소 목표 나무의 수
        int T = Integer.parseInt(st.nextToken());

        int[] treeArray = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            treeArray[i] = Integer.parseInt(st.nextToken());
        }

        // 갑 정렬
        Arrays.sort(treeArray);

        long left = 0;
        long right =  treeArray[N-1];
        long height ;

        while(left < right){
            long result =0;
            height = (left + right) / 2;

            for(int i=0; i<N; i++){
                long temp = treeArray[i] - height;
                result += (temp > 0) ? temp : 0;
            }

            // 오히려 다시 줄어들면 break;
            if(result < T){
                right = height;
            } else {
                left = height + 1;
            }

        }

        System.out.println(left - 1);
        bf.close();
    }
}
