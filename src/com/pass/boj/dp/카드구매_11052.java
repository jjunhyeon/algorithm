import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매_11052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[N+1];
		int[] card = new int[N+1];
		
		
		StringTokenizer st = new StringTokenizer(bf.readLine());		
		for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				card[i] = Math.max(card[i], card[i-j] + arr[j]);
			}
		}
		
		System.out.println(card[N]);
		bf.close();
		
	}
}
