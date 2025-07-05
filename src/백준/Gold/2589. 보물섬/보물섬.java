
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs, 완탐
public class Main {
	
	// row : 행, col : 컬럼
	static int row,col;
	// map 정보
	static int[][] map;
	static int[] xArray = {-1,0,1,0};
	static int[] yArray = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		for(int i=0; i<row; i++) {
			String row = bf.readLine();
			for(int j=0; j<col; j++) {
				char target = row.charAt(j);
				// W는 바다
				// L은 육지
				map[i][j] = (target == 'W') ? 0 : 1; 
			}
		}
		
		int answer = 0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(map[i][j] == 1) {
					answer = Math.max(answer,getShortestParthByBfs(i,j));
				}
			}
		}
		System.out.println(answer);
	}
	
	// row, col 을 시작점으로 거리 정보를 구한다.
	private static int getShortestParthByBfs(int startRow, int startCol) {
		int sum = 0;
		Queue<int[]> q = new LinkedList<>();
		// 거리 정보를 나타낼 맵
		int[][] dis = new int[row][col];
		// 방문여부 체크용도
		boolean[][] visited = new boolean[row][col];
		q.offer(new int[] {startRow,startCol});
		visited[startRow][startCol] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			for(int i=0; i<4; i++) {
				int movedX = curX + xArray[i];
				int movedY = curY + yArray[i];
				// validation check
				// 정합성 + 1은 육지, 방문하지 않음
				if(movedX >=0 && movedX < row && movedY >=0 && movedY < col && map[movedX][movedY] == 1 && !visited[movedX][movedY]) {
					visited[movedX][movedY] = true;
					q.offer(new int[] {movedX,movedY});
					dis[movedX][movedY] = dis[curX][curY] + 1;
				}
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				sum = Math.max(sum,dis[i][j]);
			}
		}
		
		return sum;
	}
}
