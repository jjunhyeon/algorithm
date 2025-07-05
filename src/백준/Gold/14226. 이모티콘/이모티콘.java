
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//
//1.  값 입력받기
//2.  이모티콘에 대한 처리
// * 모두 복사해서 클립보드에 저장한다.
// * 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
// * 화면에 있는 이모티콘 중 하나를 삭제한다.
//  -> 모두 1초가 걸린다.
// 이미 화면에 이모티콘 1개가 입력되었을 때, 위 3가지 연산을 사용해 
// 이모티콘 S개를 만드는 최솟값을 구하는 프로그램을 작성하라.
public class Main {
	static int TARGET = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TARGET = Integer.parseInt(br.readLine());
		// 스크린과 클립보드 정보
		int screen = 1;
		int clipBoard = 0;
		// 1) clipBoard = screen;
		// 2) screen += clipBoard;
		// screen -= 1;
		// 모두 복사해서 클립보드에 저장한다.
		// 현재 화면의 정보를 담고 있는 변수와 클립보드의 변수가 필요
		Queue<Emoticon> screenQ = new LinkedList<>();
		// 현재 스크린과 시간 정보를 갖도록 한다.
		screenQ.offer(new Emoticon(screen, clipBoard, 0));
		int answer = 0;

		boolean[][] visited = new boolean[10000][10000];
		visited[screen][clipBoard] = true;

		while (!screenQ.isEmpty()) {
			Emoticon curInfo = screenQ.poll();
			int curValue = curInfo.screen;
			int curTime = curInfo.time;
			int board = curInfo.board;

			if (curValue == TARGET) {
				answer = curTime;
				break;
			}
			// 값이 변화하는 조건은 3가지이다.
			// 1.화면에 있는 모든 이모티콘을 모두 복사해서 클립보드에 저장하는 케이스.
			if (!visited[curValue][curValue]) {
				visited[curValue][curValue] = true;
				screenQ.offer(new Emoticon(curValue, curValue, curTime + 1));
			}
			// 2.클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한 케이스
			if (!visited[curValue + board][board]) {
				visited[curValue + board][board] = true;
				screenQ.offer(new Emoticon(curValue + board, board, curTime + 1));
			}
			// 3.스크린의 값을 -1 처리 한 케이스
			if (curValue - 1 >= 0 && !visited[curValue - 1][board]) {
				visited[curValue - 1][board] = true;
				screenQ.offer(new Emoticon(curValue - 1, board, curTime + 1));
			}

		}
		System.out.println(answer);
	}

	public static class Emoticon {
		int screen;
		int board;
		int time;

		public Emoticon(int screen, int board, int time) {
			this.screen = screen;
			this.board = board;
			this.time = time;
		}
	}
}
