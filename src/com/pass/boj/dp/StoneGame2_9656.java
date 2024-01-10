import java.util.Scanner;

public class StoneGame2_9656 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// true -> "CY"
		// false -> "SK"
		boolean flag = true;

		while (N > 1) {
			if (N % 3 == 1) N -= 3;
			else N -= 1;
			// 반대로 업데이트
			flag = !flag;
		}

		System.out.print(flag ? "CY" : "SK");
		sc.close();
	}
}
