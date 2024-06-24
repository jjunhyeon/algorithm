
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	// 상하좌우 + 대각4개 처리를 위한 변수
	// 오른쪽 상단, 오른쪽 ,밑 , 왼쪽 하단
	static int[] xArray = { -1, 1, 0, 1, 1 };
	static int[] yArray = { 1, 0, 1, 1, -1 };
	// 오목판 19 * 19
	static int[][] MAP = new int[19][19];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 19; i++) {
			String[] row = bf.readLine().split(" ");
			for (int j = 0; j < 19; j++) {
				// 19 * 19 오목판에 오목값 세팅
				MAP[i][j] = Integer.parseInt(row[j]);
			}
		}
		// 흰 바둑돌, 또는 검은 바둑돌이 나올때마다 최대 거리를 계산해본다.
		// 만약 최대 거리 뽑아내서 6이라면 0 끝
		// 5라면 -> 어떤 돌인지 출력후, 가장 왼쪽 상단의 지점을 찾아야한다.
		// 가장 왼쪽 상단의 지점을 어떻게 찾을래?
		int row = -1;
		int col = -1;
		boolean found = false;
		int maxLen = 0;
		int winner = 0;
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (MAP[i][j] != 0) {
					int result = searchByBfs(i, j, MAP[i][j]);
					if (result == 5) {
						maxLen = result;
						winner = MAP[i][j];
						// 가장 왼쪽 상단의 지점을 찾아 업데이트
						// 세로로 일자
						// 1,0
						// 2,0
						// 3,0
						if (!found || i < row || j < col) {
							row = i;
							col = j;
						}
						found = true;
					}
				}
			}
		}

		// 정답, bw append
		if (maxLen == 0) {
			bw.append('0');
		} else {
			bw.append(Integer.toString(winner)).append("\n").append((row + 1) + " " + (col + 1));
		}
		bf.close();
		bw.flush();
		bw.close();
	}

	// 시작점 i,j 기준으로 거리 정보를 찾는다.
	private static int searchByBfs(int row, int col, int startPoint) {
		int maxCount = 0;
		for (int i = 0; i < 5; i++) {
			int count = 1;

			// 현재 방향 검사
			int nextX = row;
			int nextY = col;
			while (true) {
				nextX += xArray[i];
				nextY += yArray[i];
				if (nextX < 0 || nextX >= 19 || nextY < 0 || nextY >= 19 || MAP[nextX][nextY] != startPoint) {
					break;
				}
				count++;
				
			}

			nextX = row;
			nextY = col;
			// 반대 방향 검사
			while (true) {
				nextX -= xArray[i];
				nextY -= yArray[i];
				if (nextX < 0 || nextX >= 19 || nextY < 0 || nextY >= 19 || MAP[nextX][nextY] != startPoint) {
					break;
				}
				count++;
			}
			
			if(maxCount != 5) {
				maxCount = Math.max(maxCount, count);
			}
		}
		return maxCount;
	}
}
