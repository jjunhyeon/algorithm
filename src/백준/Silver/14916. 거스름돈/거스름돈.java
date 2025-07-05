
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 거스름돈
		int M = sc.nextInt();
		int[] coin = new int[6];
		// 5원 또는 2원으로만 남겨주어야한다.
		// 1. 먼저 5원으로 나눈 몫을 result ++
		// 13원일경우에는??
		// 2.
		// 케이스를 세분화해 만약 홀수일경우, 몫보다 -1만큼을 적재하고 차액에 +5를 해서 2원으로 나누어 지도록 한다.
		// 그래도 나누어지지 않을경우 -1을 출력한다.

		while (M > 0) {
			// 홀수라면
			if (M < 5) {
				if (M % 2 == 1) {
					if(coin[5] > 0) {
						coin[5]--;
						coin[2] += (M + 5)/ 2;	
					} else {
						// cant
						coin[2]= -1;
					}
					break;
				} else {
					coin[2] += M / 2;
					break;
				}
			}
			// 금액이 짝수일경우
			coin[5] += M / 5;
			// 나머지를 M으로 적재
			M = M % 5;
		}
		System.out.println(coin[2] == -1 ? -1 : coin[2] + coin[5]);
	}
}
