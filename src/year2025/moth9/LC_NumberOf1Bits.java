package year2025.moth9;

/*
* 이진 비트값을 10진수 값으로 처리하는 메서드 만들어보자.
* 2025-09-08 (점심시간 5분)
*/
public class LC_NumberOf1Bits {
	public static void main(String[] args) {
		int a = 128;
		solution(a);
	}

	private static int solution(int a) {
		int answer = 0;
		String value =Integer.toBinaryString(a); 
		for(final char item : value.toCharArray()) {
			if(item == '1') answer ++;
		}
		return answer;
	}
}
