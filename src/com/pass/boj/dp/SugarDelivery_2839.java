import java.util.Scanner;

// 백준 - 설탕배달
// dp 문제
public class SugarDelivery_2839 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		
		int result = 0;
		while(target > 0) {
			if(target % 5 == 0) {
				result += target / 5;
				break;
			} else {
				target -= 3;
				result ++;
			}
		}
		
		// 0을 포함하는 이유는 3으로 나누어 떨어지는 경우 값을 리턴하기 위함이다.
		System.out.print(result = (target >= 0) ? result : -1);
		sc.close();
	}
}
