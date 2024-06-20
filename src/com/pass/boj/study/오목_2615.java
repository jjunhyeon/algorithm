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
	static int[] yArray = { 0, -1, 0, 1, -1, 1, 1, -1 };
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
					winner = MAP[i][j];
					maxLen = searchByBfs(i, j, MAP[i][j]);
					System.out.println("maxLen" + maxLen);
					if (i == 0 && j == 0 && maxLen == 5) {
						row = i;
						col = j;
					}
					if (maxLen > 5)
						break outer;
				}
			}
		}

		// 정답, bw append
		if (maxLen > 5) {
			bw.append('0');
		} else {
			bw.append(Integer.toString(winner)).append("\n").append((row - 1) + " " + (col - 1));
		}
		bf.close();
		bw.flush();
		bw.close();
	}

	// 시작점 i,j를 기준으로 거리 정보를 찾는다.
	private static int searchByBfs(int row, int col, int startPoint) {
		int sum = 1; // 시작 돌을 포함하므로 1부터 시작

		// 좌우 8방향 검사
		// 오목이 되는 조건 검사
		int curX = row;
		int curY = col;
		for (int i = 0; i < 8; i++) {
			int nextX = row + xArray[i];
			int nextY = col + yArray[i];
			// 범위를 벗어나거나 돌이 다르면 중지
			while (nextX >= 0 && nextX < 19 && nextY >= 0 || nextY < 19 && MAP[nextX][nextY] == startPoint) {
				nextX += xArray[i];
				nextY += yArray[i];
				break;
			}
		}

//		count++;
//		curX = nextX;
//		curY = nextY;
		// 5개 이상이면 바로 true 반환
//		if (count > 5) {
//			return count;
//		}
		return count;
	}
}
