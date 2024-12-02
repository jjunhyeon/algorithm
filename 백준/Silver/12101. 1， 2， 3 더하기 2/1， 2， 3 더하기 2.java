
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TARGET = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<String>[] answerList = new ArrayList[TARGET + 3];

		for (int i = 0; i < TARGET + 3; i++) {
			answerList[i] = new ArrayList<>();
		}

		// 기본 1,2,3, 을 만드는 방법
		answerList[1].add("1");
		answerList[2].add("1+1");
		answerList[2].add("2");
		answerList[3].add("1+1+1");
		answerList[3].add("1+2");
		answerList[3].add("2+1");
		answerList[3].add("3");

		for (int i = 4; i <= TARGET; i++) {
			for (int j = 1; j <= 3; j++) {
				for (String item : answerList[i - j]) {
					answerList[i].add(item + "+" + j);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		if (M > answerList[TARGET].size())
			sb.append(-1);
		else {
			Collections.sort(answerList[TARGET]);
			sb.append(answerList[TARGET].get(M - 1));
		}

		System.out.println(sb);
		br.close();
	}

}
