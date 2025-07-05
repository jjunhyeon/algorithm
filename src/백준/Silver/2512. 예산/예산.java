
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int LIMIT_VALUE = Integer.parseInt(br.readLine());
		int answer = 0;
		// 정렬한다.
		Arrays.sort(arr);
		int sum = 0;
		for(int i=0; i<N; i++) {
			// 더한다 맥스 값에
			sum += arr[i];
			answer = Math.max(arr[i], answer);
		}
		
		if(sum <= LIMIT_VALUE) {
			System.out.println(answer);
			return;
		}
		
		int left = 0;
		int right = arr[N-1];
		while(left <= right) {
			int mid = (left + right)  / 2;
			long temp = 0;
			for(int i=0; i<N; i++) {
				if(arr[i] >= mid) {
					temp += mid;
				} else {
					temp += arr[i];
				}
			}
			// 지금 합계가 목표값보다 작으면
			if(temp > LIMIT_VALUE) {
				right = mid - 1;
			} else {
				left = mid + 1;
				answer = mid;
			}
		}
		
		System.out.println(answer);
	}
}
