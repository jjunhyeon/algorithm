package com.pass.boj.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 오목_2615 {
	// 상하좌우 + 대각4개 처리를 위한 변수
	static int[] xArray = { -1, 0, 1, 0, -1, 1, -1, 1 };
	static int[] yArray = { 0, -1, 0, -1, -1, 1, 1, -1 };

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
		int row = 0;
		int col = 0;
		int maxLen = 0;
		int winner = 0;
		outer: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (MAP[i][j] != 0) {
					maxLen = searchByBfs(i, j, MAP[i][j]);
					if (maxLen > 5) break outer;
					if (row == 0 && col == 0 && maxLen == 5) {
						row = i;
						col = j;
						winner = MAP[i][j];
					}
				}
			}
		}

		// 정답, bw append
		if (maxLen > 5) {
			bw.append('0');
		} else {
			bw.append(Integer.toString(winner)).append("\n").append((row + 1) + " " + (col + 1));
		}

		bf.close();
		bw.flush();
		bw.close();
	}

	// 시작점 i,j를 기준으로 거리 정보를 찾는다.
	private static int searchByBfs(int row, int col, int startPoint) {

		if(row == 5 && col == 3) {
			System.out.println("temp");
		}
		
		int max = 0;
		boolean[][] visited = new boolean[19][19];
		int[][] distance = new int[19][19];
		Queue<int[]> searchQ = new LinkedList<>();
		searchQ.offer(new int[] { row, col });

		// 기본값
		distance[row][col] = 1;
		visited[row][col] = true;

		while (!searchQ.isEmpty()) {
			int[] cur = searchQ.poll();
			int curX = cur[0];
			int curY = cur[1];
			for (int i = 0; i < 8; i++) {
				int movedX = curX + xArray[i];
				int movedY = curY + yArray[i];
				// 기본 Validation + 오목값 일치 여부
				while (movedX >= 0 && movedX < 19 && movedY >= 0 && movedY < 19 && !visited[movedX][movedY]
						&& MAP[movedX][movedY] == startPoint) {
					int previousX = movedX - xArray[i];
					int previousY = movedY - yArray[i];
					if(previousX < 0 && previousX >= 19 && previousY < 0 && previousY >= 19) {
						previousX = curX;
						previousY = curY;
					}
					distance[movedX][movedY] = distance[previousX][previousY] + 1;
					visited[movedX][movedY] = true;
					movedX += xArray[i];
					movedY += yArray[i];
					searchQ.offer(new int[] { movedX, movedY });
				}
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				max = Math.max(max, distance[i][j]);
			}
		}

		return max;
	}
}
