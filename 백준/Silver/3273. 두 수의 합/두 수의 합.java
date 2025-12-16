import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다. 
 * ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다. 자연수 x가 주어졌을 때, 
 * ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.
 * 두수의합[정렬, 투포인터]
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i <N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(br.readLine());
		br.close();
		// arr 정렬
		Arrays.sort(arr);
		int left =0;
		int right = N -1;
		int count =0;
		while(left < right) {
			int sum = arr[left] + arr[right];
			//값이 일치한다면
			if(x == sum) {
				left++;
				right--;
				count++;
			} else if(sum < x) {
				left++;
			} else  {
				right--;
			}
		}
		System.out.println(count);
	}
}