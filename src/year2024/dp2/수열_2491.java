package src.year2024.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전혀 dp스럽지 않게 추잡하게 푼 방식
public class 수열_2491 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int firstNum = array[0];
		StringBuilder status = new StringBuilder();

		int result = 0;
		int upValue = 1;
		int downValue = 1;
		for (int i = 1; i < N; i++) {

			// 초기 값
			if (status.length() < 1) {
				if (firstNum < array[i]) {
					status.append("UP");
					upValue++;
				} else if (firstNum > array[i]) {
					status.append("DOWN");
					downValue++;
				} else {
					status.append("SAME");
					upValue++;
					downValue++;
				}
			} else {
				if (status.toString().equals("SAME")) {
					// 다음 값이 더 크다 -> UP
					if (firstNum < array[i]) {
						status.setLength(0);
						status.append("UP");
						upValue++;
						downValue = 1;
					} else if (firstNum > array[i]) {
						status.setLength(0);
						status.append("DOWN");
						downValue++;
						upValue = 1;
					} else {
						status.setLength(0);
						status.append("SAME");
						upValue++;
						downValue++;
					}

				} else if (status.toString().equals("UP")) {
					if (firstNum < array[i]) {
						upValue++;
					} else if (firstNum > array[i]) {
						status.setLength(0);
						status.append("DOWN");
						upValue = 1;
						downValue++;
					} else {
						status.setLength(0);
						status.append("SAME");
						upValue++;
						downValue++;
					}
				} else if (status.toString().equals("DOWN")) {
					if (firstNum < array[i]) {
						status.setLength(0);
						status.append("UP");
						upValue++;
						downValue = 1;
					} else if (firstNum > array[i]) {
						downValue++;
					} else {
						status.setLength(0);
						status.append("SAME");
						upValue++;
						downValue++;
					}
				}
			}
			// 값 업데이트
			firstNum = array[i];
			result = Math.max(result, Math.max(upValue, downValue));
		}

		bf.close();
		System.out.println(N == 1 ? 1 : result);
	}
}
