package year2025.month2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 골드 5 백트레킹 기본 유형 문제 2/09 15: 30 ~ :16 : 30
 */
public class 암호만들기_1759 {

	static int T, L;
	static String[] password;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// T, 정답의 LEN
		T = Integer.parseInt(st.nextToken());
		// L, 주어지는 문자열의 수
		L = Integer.parseInt(st.nextToken());

		password = new String[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) {
			password[i] = st.nextToken();
		}

		// 기본조건, 사전식 정렬
		Arrays.sort(password);

		dfs(0, 0, new StringBuilder());
		br.close();
		bw.flush();
		bw.close();
	}

	// @param : 깊이
	// @param : 방문여부
	private static void dfs(int depth, int start, StringBuilder sb) throws IOException {
		// 깊이가 T
		if (depth == T) {
			// validate sb
			// sb가 자음이 포함되어 있고 모음이 2개이상 있는지 체크
			if (validate(sb)) {
				bw.append(sb).append("\n");
			}
			return;
		}

		for (int i = start; i < L; i++) {
			sb.append(password[i]);
			dfs(depth + 1, i + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static boolean validate(StringBuilder sb) {
		boolean isJaContain = false;
		int moCount = 0;
		List<Character> base = Arrays.asList('a', 'e', 'i', 'o', 'u');

		int len = sb.length();
		for (int i = 0; i < len; i++) {
			if (isJaContain && moCount >= 2)
				return true;

			if (isJaContain == false && base.contains(sb.charAt(i))) {
				isJaContain = true;
				continue;
			}
			if (!base.contains(sb.charAt(i))) {
				moCount++;
			}
		}

		return (isJaContain && moCount >= 2) ? true : false;
	}
}
