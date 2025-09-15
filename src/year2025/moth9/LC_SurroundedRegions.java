package year2025.moth9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* 2차원배열 O,X 정보가 담긴 배열을 받아
* 
*/
public class LC_SurroundedRegions {
	
	public static boolean[][] visited;
	public static int row, col;
	public static int[] xRange = {-1,0,1,0};
	public static int[] yRange = {0,1,0,-1};
	public static char[][] copied;
	
	public static void main(String[] args) {
	   char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
	   solution(board);
	}

	private static void solution(char[][] board) {
		// 이차원배열을 탐색하며 O인 지점을 만나면 주변을 찾아나가는 BFS 탐색을 시작한다.
		// Quee에 담아 탐색하며 만약 EDGE에 인접한 지점일 경우 해당 영역은 그대로 O로 남기며 
		// EDGE와 인접한 영역이 존재하지 않을경우 해당 영역을 모두 X로 바꿔버린다.
		row = board.length;
		col = board[0].length;
		visited = new boolean[row][col];
		copied = new char[row][col];
		for(int i=0; i<board.length; i++) {
			copied[i] = board[i].clone();
		}
		
		// 꼭지점 중복에 대해 고민
		for(int i=0; i < col; i++) {
			if(!visited[0][i] && board[0][i] == 'O') {
				bfs(0,i);
			}
		}
		
		// 0,n 1,n  2,n  3,n ... n,n
		for(int i=0; i<row; i++) {
			if(!visited[i][col -1] && board[i][col - 1] == 'O' ) {
				bfs(i, col -1);
			}
		}
		
		// (n,0) n,(n+1)  n, (n-2) ... n,n
		for(int i=1; i < col; i++) {
			if(!visited[row - 1][i] && board[row - 1][i] == 'O' ) {
				bfs(row - 1  , i);
			}
		}
		
		// (n),0  (n-1),0 ... 0,0
		for(int i=row - 1; i>0; i--) {
			if(!visited[i][0] && board[i][0] == 'O' ) {
				bfs(i ,0);
			}
		}
		
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(board[i][j] == 'O' && !visited[i][j])  {
					board[i][j] ='X';
				}
			}
		}
	}
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<int[]> target = new LinkedList<int[]>();
		target.add(new int[] {x,y});

		// 자기자신 방문처리
		visited[x][y] = true;
		while(!target.isEmpty()) {
			int[] cur = target.poll();
			for(int i=0; i<4; i++) {
				int nextX = cur[0] + xRange[i];
				int nextY = cur[1] + yRange[i];
				// 정상범위이면서 O 이면서 방문하지 않았다면
				if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && !visited[nextX][nextY] && copied[nextX][nextY] == 'O') {
					if(copied[x][y] != 'T'){
						copied[x][y] = 'T';
					}
					visited[nextX][nextY] = true;
					copied[nextX][nextY] = 'T';
				}
			}
		}
	}
}
