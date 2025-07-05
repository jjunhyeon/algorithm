
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken());

		Arrays.sort(arr);
		long answer = 0;
		int left = 0;
		int right = N;
		if (N % 2 == 0) {
			while (left < right) {
				answer = Math.max(answer, arr[left] + arr[right - 1]);
				left++;
				right--;
			}
		} else {
			if (N == 1) {
				System.out.println(arr[0]);
				return;
			}
			while (left < right) {
				answer = Math.max(answer, arr[left] + arr[right - 2]);
				left++;
				right--;
			}

			answer = Math.max(answer, arr[right - 1]);
		}

		System.out.println(answer);
	}
}
