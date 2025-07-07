package year2024.programmers;

import java.util.ArrayList;
import java.util.List;

// 하노이의탑
public class 하노이의탑_12946 {
	static List<int[]> answerList;

	public static void main(String[] args) {

		int params = 3;
		solution(params);
	}

	private static int[][] solution(int n) {
		answerList = new ArrayList<>();
		dfs(n, 1, 3, 2);

		int[][] answer = new int[answerList.size()][];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}

	private static void dfs(int n, int start, int to, int mid) {
		if (n == 1) {
			answerList.add(new int[] { start, to });
			return;
		}
		// 1번 기둥의 n-1개를 3번을 걸쳐 2번으로 이동시킴
		dfs(n - 1, start, mid, to);

		// 가장 큰 n을 1에서 3으로 이동시킴
		answerList.add(new int[] { start, to });

		// 2번의 기둥의 n-1개를 1번을 걸쳐 3번으로 이동시킴
		dfs(n - 1, mid, to, start);
	}
}
