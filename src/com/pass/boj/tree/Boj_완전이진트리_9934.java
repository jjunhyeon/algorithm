import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 - 완전이진트리문제
public class Boj_완전이진트리_9934 {

	public static int[] array;
	public static StringBuilder[] sb;
	public static int L;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(bf.readLine());

		StringTokenizer st = new StringTokenizer(bf.readLine());

		array = new int[(int) Math.pow(2, L) - 1];
		for (int i = 0; i < array.length; i++)
			array[i] = Integer.parseInt(st.nextToken());

		// StringBuilder 배열로 선언한 이유는
		// 문제에서 최종 return 해야하는 레벨 정보를 알 수 있고
		// 내부 값이 동적으로 변해야하는 자료구조가 필요해서 사용했다.
		sb = new StringBuilder[L];

		for (int i = 0; i < L; i++)
			sb[i] = new StringBuilder();

		getAnswer(0, array.length - 1, 0);

		for (int i = 0; i < sb.length; i++)
			System.out.println(sb[i].toString().trim());

		bf.close();
	}

	// @param : start
	// @param : end
	// @param : depth
	private static void getAnswer(int start, int end, int depth) {

		// 재귀의 방향은 왼쪽, 오른쪽
		if (depth == L) {
			return;
		}

		int value = array[(start + end) / 2];
		sb[depth].append(value + " ");

		// 왼쪽은 0부터 중위순회값까지
		// 오른쪽은 중위순회+1부터 오른쪽 끝가지
		// 왼쪽 dfs
		// 오른쪽 dfs
		getAnswer(start, (start + end) / 2 - 1, depth + 1);
		getAnswer((start  + end) / 2 + 1, end, depth + 1);

	}
}
