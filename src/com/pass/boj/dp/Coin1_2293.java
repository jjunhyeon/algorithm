import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin1_2293 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int[] coin = new int[K+1];
        
        // coin[x] = m;
        // x-> 금액, m -> x원을 만드는 가능한 경우의 수
        coin[0] = 1;
        
        for(int i = 1 ; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= K; j++) {
            	coin[j] += coin[j - arr[i]];
            }
        }

        System.out.println(coin[K]);
	}
}
