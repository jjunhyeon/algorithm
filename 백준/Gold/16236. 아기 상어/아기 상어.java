
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 아기상어1
// 아기상어의 크기는 2이고, 1초에 상하좌우 1칸씩 움직인다.
// 자신보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있음
// 자신의 크기보다 작은 물고기만 먹을 수 있음
// +++ 크키각 같은 물고기는 먹을 순 없지만 지나갈 수는 잇음!!!
// 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으로 가고
// 만약 먹을 수 있는 물고기가 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
// 거리가 가장 가까운 물고기도 여럿이라면 
// 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면 가장 왼쪽에 잇는 물고기를 먹는다.
// [가장 위에 있는 물고기가 여럿일 수 있나????

// 물고기를 만약 먹으면 그 칸은 빈칸이 된다.
// 자신의 크기ㄱ와 같은 수의 물고리를 먹을 때마다 크기가 1 증가
// EX) 크기가 2인 물고기가 크기가 커지라면 2마리를 먹었을때 3이 된다.
// 결론 : 엄마 상어에게 도움을 요청하지 않고 몇초동안 물고기를 잡아먹을 수 있는지 구해라.
// 입력값 정보
// 0 : 빈칸
// 1,2,3,4,5,6 : 칸에 있는 물고기
// 9 : 아기 상어의 위치
public class Main {
	// 맵 정보와 거리 정보를 가질 맵 생성
	static int[][] MAP, DIS;
	// 맵의 크기
	static int S;
	static int ateFish = 0;
	static int sharkSize = 2;
	static int[] xArray = { -1, 0, 1, 0 };
	static int[] yArray = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 맵의 크기(Size)
		S = Integer.parseInt(br.readLine());
		MAP = new int[S][S];
		DIS = new int[S][S];

		// 아기상어의 위치 정보를 가질 변수
		int startRow = 0;
		int startCol = 0;

		// 1. 입력값 처리
		for (int i = 0; i < S; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < S; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				// 시작하는 상어의 위치를 저장한다.
				if (MAP[i][j] == 9) {
					startRow = i;
					startCol = j;
				}
			}
		}

		// 찾은 상어의 위치를 기준으로
		// 가장 가까운 상어를 찾는다.
		// 아기상어의 기본 크기는 2이다.
		getShortestTimeByBfs(startRow, startCol);
	}

	private static void getShortestTimeByBfs(int startRow, int startCol) {
		boolean[][] visited = new boolean[S][S];
		// 상어의 정보가 필요하다
		Queue<Shark> sharkQ = new LinkedList<>();
		sharkQ.offer(new Shark(startRow, startCol));
		int time = -1;
		visited[startRow][startCol] = true;
		int answer = 0;
		
		// 탐색 시작
		while (!sharkQ.isEmpty()) {
			int sharkCount = sharkQ.size();
			time++;
			
			boolean isAteFish = false;
			// 거리 조건을 충족하기 위한 변수
	        int minR = Integer.MAX_VALUE;
	        int minC = Integer.MAX_VALUE;
	        
			while (sharkCount-- > 0) {
				Shark info = sharkQ.poll();
				int curRow = info.row;
				int curCol = info.col;
				// 먹을 수 있는 상어인지 검사
				
				
				if (MAP[curRow][curCol] != 0 && MAP[curRow][curCol] < sharkSize) {
					if (curRow < minR) {
						minR = curRow;
						minC = curCol;
					} else if (curRow == minR) {
						if (curCol < minC) {
							minC = curCol;
						}
					}
					isAteFish = true; // 먹었다는 표시를 나타내기 위한 flag
					continue;
				}

				// 물고기 못먹으면 탐색
				if (!isAteFish) {
					for (int i = 0; i < 4; i++) {
						int nextRow = curRow + xArray[i];
						int nextCol = curCol + yArray[i];
						if (nextRow < 0 || nextRow >= S || nextCol < 0 || nextCol >= S
								|| MAP[nextRow][nextCol] > sharkSize || visited[nextRow][nextCol]) continue;
						sharkQ.add(new Shark(nextRow, nextCol));
						visited[nextRow][nextCol] = true;
					}
				}
			}
			if (isAteFish) { // 먹을 수 있다면
				ateFish++;
				answer = time;
				MAP[startRow][startCol] = 0;
				MAP[minR][minC] = 0;
				startRow = minR;
				startCol = minC;

				if (ateFish == sharkSize) {
					sharkSize++;
					ateFish = 0;
				}
				sharkQ.clear();
				sharkQ.offer(new Shark(startRow, startCol));
				visited = new boolean[S][S];
				visited[startRow][startCol] = true;
				time --;
			}
		}
		System.out.println(answer);
	}

	static class Shark {
		// 위치정보
		int row;
		int col;

		Shark(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
