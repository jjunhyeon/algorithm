import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 2월 27일 ,12:30 ~ 13:00 -> 실패, 시간초과
 * 백트레킹 문제 N과 M(3)
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
 * 중복되는 수열은 여러번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * 
*/
public class Main {
	static int N, M;
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
		for (int i = 1; i <= N; i++) defaultArray[i] = i;
		
		getTargetByDfs(new StringBuilder(), 0);
		bw.flush();
		br.close();
		bw.close();
	}

	private static void getTargetByDfs(StringBuilder curString, int depth) throws IOException {
		// return ; 시점은
		if (depth == M) {
            for (int i = 0; i < M; i++) {
                if (i > 0) bw.append(" ");
                bw.append(curString.charAt(i));
                if(i == M - 1) bw.append("\n");
            }
			return;
		}

		for (int i = 1; i <= N; i++) {
			curString.append(defaultArray[i]);
			getTargetByDfs(curString, depth + 1);
			curString.deleteCharAt(curString.length() - 1);
		}
	}
}
