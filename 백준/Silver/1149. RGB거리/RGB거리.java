import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N -> 집의 수
        int N = sc.nextInt();
        int[][] arr = new int[1001][3];
        for (int i = 1; i <= N; i++) {
            int R = sc.nextInt();
            int G = sc.nextInt();
            int B = sc.nextInt();
            arr[i][0] = Math.min(arr[i-1][1],arr[i-1][2]) + R;
            arr[i][1] = Math.min(arr[i-1][0],arr[i-1][2]) + G;
            arr[i][2] = Math.min(arr[i-1][1],arr[i-1][0]) + B;
        }
        System.out.println(Math.min(arr[N][2],Math.min(arr[N][0],arr[N][1])));
    }
}