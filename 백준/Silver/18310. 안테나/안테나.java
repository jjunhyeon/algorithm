
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 안테나를 설치할 위치값
		int AN = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 안테나의 정보를 담을 배열
		int[] anArray = new int[AN];
		for (int i = 0; i < AN; i++) {
			anArray[i] = Integer.parseInt(st.nextToken());
		}

		// 가운데 값 도출을 위해 정렬한다
		Arrays.sort(anArray);

		// 배열의 길이
		int len = anArray.length;
		int answer = 0;
		int sum = 0;
		// 배열의 길이가 짝수일 경우, 짝수의 경우 가운데 렝스의 길이를 n/2 와 n/2 -1 을 같이 비교해줘야한다.
		int temp = 0;
		if (len % 2 == 0) {
			int mid1 = len / 2;
			int mid2 = len / 2 - 1;
			for (int i = 0; i < len; i++) {
				sum += Math.abs(anArray[mid1] - anArray[i]);
				temp += Math.abs(anArray[mid2] - anArray[i]);
			}
			if (sum == temp) {
				answer = Math.min(anArray[mid1], anArray[mid2]);
			} else {
				answer = sum < temp ? mid1 : mid2;
			}
		} else {
			answer = anArray[len / 2];
		}

		System.out.println(answer);
	}
}
