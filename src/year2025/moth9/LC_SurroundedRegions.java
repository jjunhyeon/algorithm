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
		char[][] copied = new char[row][col];
		for(int i=0; i<board.length; i++) {
			copied[i] = board[i].clone();
		}
		
		// 개선 ) 전체 탐색 X, EDGE를 탐색하며 O인 지점만 ㄱㄱ
		for(int i=0; i< board.length; i++) {
			for(int j=0; j< board[i].length; j++) {
				// 값이 탐색할지점 o 이며 방문하지 않았을경우 bfs 탐색을 시작함.
				if(board[i][j] == 0 && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		
	}
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<int[]> target = new LinkedList<int[]>();
		target.add(new int[] {x,y});
		
		while(!target.isEmpty()) {
			int[] cur = target.poll();
			
			for(int i=0; i<4; i++) {
				int nextX = cur[0] + xRange[i];
				int nextY = cur[1] + yRange[i];
				// 정상범위라면
//				if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && !visited[nextX][nextY]) {
//					visited[nextX][nextY] = true;
//				}
			}
		}
	}
}
