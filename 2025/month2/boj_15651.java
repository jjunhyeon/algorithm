package month2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 2월 27일 ,12:30 ~ 13:00 
 * 백트레킹 문제 N과 M(3)
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
 * 중복되는 수열은 여러번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * 
 * 1. 수열 전체 출력 -> BufferwdWriter 활용
 * 2. 중복되는 수열을 여러번 출력 X -> 중복 체크 필요
 * 3. 수열은 사전 순 증가 -> start 파라미터를 입력받는다.
 * 
*/
public class boj_15651 {
	static int N, M;
	static List<String> isChecked = new ArrayList<>();
	static int[] defaultArray;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1부터 N까지 자연수 중에서 M개를 고른 수열
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		defaultArray = new int[N + 1];
		// 기본 배열의 값에 Array[i] = i; 세팅
		for (int i = 1; i <= N; i++) defaultArray[i] = i;
		getTargetByDfs(1, new StringBuilder());
	}

	private static void getTargetByDfs(int start, StringBuilder curString) {
		// return ; 시점은
		// curString이 target이 된 순간
		if (curString.length() == M) {
			// duplicated check
			// String.join은 배열값에 대해 왼쪽 파라미터 값을 기준으로 연결하여 출력하게 해준다.
			String cur = String.join(" ", curString.toString().split(""));
			// 만약 기존에 출력된 값이 아니라면 출력
			if(!isChecked.contains(cur)) {
				System.out.println(cur);
				isChecked.add(cur);
			}
			return;
		}

		// FIXME 전체 탐색으로 전환 필요
		for (int i = start; i <= N; i++) {
			curString.append(defaultArray[i]);
			getTargetByDfs(i, curString);
			curString.deleteCharAt(curString.length()-1);
		}
	}
}
