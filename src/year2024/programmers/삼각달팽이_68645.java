package year2024.programmers;

public class 삼각달팽이_68645 {

	public static void main(String[] args) {
		solution(4);
	}

	public static int[] solution(int n) {
		int[] answer = new int[n*(n+1) / 2]; 

		int row = -1;
		int col = 0;
		int[][] doubleArray = new int[n][n];
		int value = 1;
		for (int i = n; i > 0; i -= 3) {
			for (int j = 0; j < i; j++)
				doubleArray[++row][col] = value++;
			for (int k = 0; k < i - 1; k++)
				doubleArray[row][++col] = value++;
			for (int m = 0; m < i - 2; m++)
				doubleArray[--row][--col] = value++;
		}
		int index = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(doubleArray[i][j] == 0) break;
				answer[index++] = doubleArray[i][j];
			}
		}
		return answer;
	}
}
