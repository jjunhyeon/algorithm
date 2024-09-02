import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int PRESENT_COUNT = Integer.parseInt(st.nextToken());
		int BUDGET = Integer.parseInt(st.nextToken());
		int DISCOUNT_COUNT = Integer.parseInt(st.nextToken());

		int[] array = new int[PRESENT_COUNT];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < PRESENT_COUNT; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		// 선물에 대한 값을 정렬한다.
		Arrays.sort(array);

		// 정렬 후 start, end 지점을 잡고 앞에서 부터 탐색한다.
		// DISCOUNT 정보가 있는거에 대한 IF를 구분하고
		// 있을경우 sum에 할인 갑을 누적시키고
		// 만약 DISOCUNT가 더이상 존재하지 않을경우 START와 END지점을 조절하며 최종 확정한다.
		int sum = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < PRESENT_COUNT; i++) {
			// 할인가능
			if (DISCOUNT_COUNT > 0) {
				if (sum + array[i] / 2 > BUDGET) {
					break;
				} else {
					sum += array[i] / 2;
					DISCOUNT_COUNT--;
					end = i + 1;
				}
			} else { // 할인불가
				sum += array[start] / 2;
				sum += array[end] / 2;
				if (sum > BUDGET) {
					break;
				} else { // end를 더 확보할수 있으면
					start++;
					end++;
				}
			}
		}

		System.out.println(end);
	}
}
