
// 이분탐색 기본문제
// 이분탐색이란?
// 정렬되어 있는 리스트에서 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 방법
// 배열 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘이다.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 배열의 범위 길이
		int ARRAY_LEN = Integer.parseInt(br.readLine());
		int[] ARRAY = new int[ARRAY_LEN];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < ARRAY_LEN; i++) {
			ARRAY[i] = Integer.parseInt(st.nextToken());
		}

		// 확인해야하는 타겟 넘버의 수
		int TARGET_COUNT = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Arrays.sort(ARRAY);
		while (TARGET_COUNT-- > 0) {
			int cur = Integer.parseInt(st.nextToken());
			// 초기값
			int left = 0;
			int right = ARRAY_LEN - 1;
			int mid = 0;
			boolean isExist = false;
			while (left <= right) {
				mid = (left + right) / 2;
				// 현재값이 미드값보다 작을경우
				if (cur < ARRAY[mid]) {
					right = mid - 1;
				} else if (cur > ARRAY[mid]) {
					left = mid + 1;
				} else {
					isExist = true;
					break;
				}
			}
			bw.append(isExist ? "1" : "0").append("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
