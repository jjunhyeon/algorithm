
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer,Integer> bInfo = new HashMap<>();
		
		int[] aArray = new int[N];
		int[] bArray = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			aArray[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int j=0; j<N; j++) {
			bArray[j] = Integer.parseInt(st.nextToken());
			// 값과 순서를 담아둔다.
			bInfo.put(bArray[j], j);
		}
		
		Integer[] integerArr = Arrays.stream(bArray).boxed().toArray(Integer[] :: new);
		Arrays.sort(integerArr,Comparator.reverseOrder());
		Arrays.sort(aArray);
		
		long min = 0;
		for(int i=0; i<N; i++) {
			min += integerArr[i] * aArray[i];
		}
		
		br.close();
		System.out.println(min);
	}
}