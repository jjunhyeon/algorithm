package year2024.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 컴백홈
// INPUT : ROW, COL, DIS
public class 컴백홈_1189 {
	static int row, col, dis;
	static int[][] map;
	static int[] xArray = { -1, 0, 1, 0 };
	static int[] yArray = { 0, 1, 0, -1 };
	static int sum = 0;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		dis = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			String line = bf.readLine();
			for (int j = 0; j < col; j++) {
				char cur = line.charAt(j);
				// T는 갈수없는 영역
				map[i][j] = cur == 'T' ? 0 : 1;
			}
		}
		// 첫 시작은 왼쪽 하단
		visited[row - 1][0] = true;
		getSolutionByDfs(row - 1, 0, 1);
		System.out.println(sum);
	}

	private static void getSolutionByDfs(int curRow, int curCol, int target) {
		// 거리 값이 목표값이라면\
		if (curRow == 0 && curCol == col - 1) {
			if (target == dis) {
				sum++;
				return;
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int movedX = curRow + xArray[i];
				int movedY = curCol + yArray[i];
				if (movedX >= 0 && movedX < row && movedY >= 0 && movedY < col && !visited[movedX][movedY]
						&& map[movedX][movedY] != 0) {
					visited[movedX][movedY] = true;
					getSolutionByDfs(movedX, movedY, target + 1);
					visited[movedX][movedY] = false;
				}
			}
		}
	}
}
