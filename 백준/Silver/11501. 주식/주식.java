
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// TEST CASE 의 수
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			// 일자정보
			// answer 소득정보
			long income = 0;
			int DAY = Integer.parseInt(br.readLine());

			int[] dayInfo = new int[DAY];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < DAY; i++) {
				dayInfo[i] = Integer.parseInt(st.nextToken());
			}

			// 현재 날을 기준으로 가장 최대값의 주식 정보를 담을 배열
			int[] nextMax = new int[DAY];
			nextMax[DAY - 1] = dayInfo[DAY - 1]; // 마지막 날 주가는 그날의 최대값

			// TODO
			// 날을 기준으로 뒤에서부터 탐색하며 해당 날을 기준으로 미래의 최고가 주식 가격정보를 담아둔다.
			for (int i = DAY - 2; i >= 0; i--) {
				nextMax[i] = Math.max(dayInfo[i], nextMax[i + 1]);
			}

			// nextMax의 최대 가격정보와 기존 DAY의 주식 가격을 비교하며 정답 출력
			for (int i = 0; i < DAY; i++) {
				income += nextMax[i] - dayInfo[i];
			}

			if (T > 0) bw.append(String.valueOf(income)).append("\n");
			else bw.append(String.valueOf(income));
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
