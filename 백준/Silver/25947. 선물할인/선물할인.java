
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 그리디 - 선물할린
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 선물의개수,예산,할인 가능 선물의 수
		int PRESENT_COUNT = Integer.parseInt(st.nextToken());
		int BUDGET = Integer.parseInt(st.nextToken());
		int DISCOUNT_COUNT = Integer.parseInt(st.nextToken());

		int[] preSent = new int[PRESENT_COUNT];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < PRESENT_COUNT; i++) {
			preSent[i] = Integer.parseInt(st.nextToken());
		}
		// 순차적으로 값을 누적시키기 위해 정렬한다.
		Arrays.sort(preSent);
		int sum = 0;
		// 모든 품목에 대해 할인 가능한 케이스
		int start = 0;
		int end = 0;

		for (int i = 0; i < PRESENT_COUNT; i++) {
			if (DISCOUNT_COUNT > 0) {
				// BUDGET을 초과한시에서 break;
				if (sum + preSent[i] / 2 > BUDGET) {
					break;
				} else {
					sum += preSent[i] / 2;
					DISCOUNT_COUNT--;
					end = i + 1;
				}
			} else { // 할인불가, 할인 카운트 전부 사용
				// 합계 적용
				// 할인품목 시자지점과 끝지점을 조절해주는 부분
				sum += preSent[start] / 2;
				sum += preSent[end] / 2;
				if (sum > BUDGET) {
					break;
				} else {
					start++;
					end++;
				}
			}

		}
		System.out.println(end);
	}
}
