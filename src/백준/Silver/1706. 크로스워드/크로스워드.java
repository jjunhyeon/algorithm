
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		List<String> stList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		char[][] arr = new char[row][col];

		for (int i = 0; i < row; i++) {
			String line = br.readLine();
			for (int j = 0; j < col; j++) {
				arr[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < row; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < col; j++) {
				if (arr[i][j] != '#')
					sb.append(arr[i][j]);
				else {
					if (sb.length() > 1) {
						stList.add(sb.toString());
					}
					// sb 초기화
					sb.setLength(0);
					continue;
				}
				// #이 없이 끝난 케이스
				if (sb.length() > 1 && j == col - 1) {
					stList.add(sb.toString());
				}
			}
		}

		for (int i = 0; i < col; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < row; j++) {
				if (arr[j][i] != '#')
					sb.append(arr[j][i]);
				else {
					if (sb.length() > 1) {
						stList.add(sb.toString());
					}
					// sb 초기화
					sb.setLength(0);
					continue;
				}
				// #이 없이 끝난 케이스
				if (sb.length() > 1 && j == row - 1) {
					stList.add(sb.toString());
				}
			}
		}
        br.close();
		Collections.sort(stList);
		System.out.println(stList.get(0));

	}
}
