
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int arrayCount = Integer.parseInt(st.nextToken());
		int TARGET = Integer.parseInt(st.nextToken());

		int[] array = new int[arrayCount];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < arrayCount; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		int start = 0;
		int end = 0;

		
		for (int i = 0; i < arrayCount; i++) {
			int sum = 0;
			start = i;
			end = start + 1;
			sum += array[start];
			
			if(sum == TARGET) {
				answer++;
				continue;
			}
			while (end < arrayCount) {
				sum += array[end];
				// 시작지점과 끝지점을 더한값이 > 목표값보다 크면
				if (sum > TARGET) {
					break;
				} else if (sum < TARGET) {
					end++;
				} else {
					answer++;
					break;
				}

			}
		}

		System.out.println(answer);
	}
}
