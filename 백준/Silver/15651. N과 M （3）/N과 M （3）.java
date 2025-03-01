
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
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
public class Main {
	static int N, M;
	static Set<String> isChecked = new HashSet<>();
	static int[] defaultArray;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1부터 N까지 자연수 중에서 M개를 고른 수열
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		defaultArray = new int[N + 1];
		// 기본 배열의 값에 Array[i] = i; 세팅
		for (int i = 1; i <= N; i++)
			defaultArray[i] = i;
		getTargetByDfs(new StringBuilder(), 0);
		bw.flush();
		br.close();
		bw.close();
	}

	private static void getTargetByDfs(StringBuilder curString, int depth) throws IOException {
		// return ; 시점은
		if (depth == M) {
			// duplicated check
			// String.join은 배열값에 대해 왼쪽 파라미터 값을 기준으로 연결하여 출력하게 해준다.
			// String cur = String.join(" ", curString.toString().split(""));
			// -> 문자사이에 공백 넣기 로직 개선 필요 
			// -> 시간초과발생
			// 만약 기존에 출력된 값이 아니라면 출력
			// bw에 apeend
			if (!isChecked.contains(curString.toString())) {
				bw.append(String.join(" ", curString.toString().split(""))).append("\n");
				isChecked.add(curString.toString());
			}
			return;
		}

		// FIXME 전체 탐색으로 전환 필요
		for (int i = 1; i <= N; i++) {
			curString.append(defaultArray[i]);
			getTargetByDfs(curString, depth + 1);
			curString.deleteCharAt(curString.length() - 1);
		}
	}
}
