import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 코드 개선 
// 메모리 사용량 33000 -> 21000
// 시간 244ms -> 196ms 단축
// 불필요한 변수와 로직을 줄여 적용시켰다.
public class 수열_2491_update {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int result = 1;
		int upValue = 1;
		int downValue = 1;
		for (int i = 1; i < N; i++) {
			if (array[i - 1] < array[i]) {
				upValue++;
				downValue = 1;
			} else if (array[i - 1] > array[i]) {
				downValue++;
				upValue = 1;
			} else {
				downValue++;
				upValue++;
			}

			result = Math.max(result, Math.max(upValue, downValue));
		}

		bf.close();
		System.out.println(result);
	}
}
