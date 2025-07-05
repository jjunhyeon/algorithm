
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 - 최장 부분 순열
 * LCS(Longest Common Subsequence, 최장 공통 부분 순열)
 * */
public class Main {

    public static String firstString;
    public static String secondString;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        firstString = bf.readLine();
        secondString = bf.readLine();
        if (firstString.equals(secondString)) {
            System.out.println(firstString.length());
        } else {

            String newFirstString = " " + firstString;
            String newSecondString = " " + secondString;

            int newFirstStringSize = newFirstString.length();
            int newSecondStringSize = newSecondString.length();

            int[][] lcsMatrix = new int[newFirstStringSize][newSecondStringSize];
            for (int i = 1; i < newFirstStringSize; i++) {
                for (int j = 1; j < newSecondStringSize; j++) {
                    if (newFirstString.charAt(i) == newSecondString.charAt(j)) {
                        lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                    } else {
                        lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
                    }
                }
            }

            System.out.println(lcsMatrix[newFirstStringSize - 1][newSecondStringSize - 1]);
        }
    }
}