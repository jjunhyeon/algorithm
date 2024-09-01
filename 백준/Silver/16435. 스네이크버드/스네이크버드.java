import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// fruitCount : 과일의개수
		// snakeSize : 뱀의 크기
		int fruitCount = Integer.parseInt(st.nextToken());
		int snakeSize = Integer.parseInt(st.nextToken());
		
		// 과일의 정보를 담을 배열
		int[] fruitInfo = new int[fruitCount];
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<fruitCount; i++) fruitInfo[i] = Integer.parseInt(st.nextToken());
		
		// 정렬
		Arrays.sort(fruitInfo);
		for(Integer item : fruitInfo) {
			if(snakeSize >= item) snakeSize++;
		}
		
		System.out.println(snakeSize);
		bf.close();
	}
}
