package src.year2024.dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_파도반수열_9461 {

	static long[] fadoDp = new long[101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// TEST CASE 
		int T = Integer.parseInt(bf.readLine());
		setPadoNumber(100);
		while(T --> 0) {
			int N = Integer.parseInt(bf.readLine());
			long result = setPadoNumber(N);
			bw.write(Long.toString(result));
			bw.newLine();
		}
		
		bf.close();
		bw.close();
	}

	private static long setPadoNumber(int target) {
		
		if(fadoDp[target] != 0 ) {
			return fadoDp[target];
		}
		
		// 초기값 1~5 지정
		if(target <= 3) return 1;
		else if(target <= 5) return 2;
		else if(target == 6) return 3;
		else return fadoDp[target] = setPadoNumber(target - 2) + setPadoNumber(target - 3); 
	} 
}
