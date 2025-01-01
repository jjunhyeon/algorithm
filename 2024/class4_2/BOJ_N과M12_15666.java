package class4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_N과M12_15666 {

	public static StringTokenizer st;
	public static int N, M;
	public static HashSet<String> answerHashSet = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] array = new int[N];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < array.length; i++)
			array[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(array);

		int[] result = new int[M];
		// depth, array, target
		dfs(0, array, 0, result);
		Iterator iter = answerHashSet.iterator();
		while(iter.hasNext()) System.out.println(iter.next());
	}

	private static void dfs(int depth, int[] array, int target,int[] result) {

		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				if(i < M -1) sb.append(result[i]+" ");
				else sb.append(result[i]);
			}
			answerHashSet.add(sb.toString());
			return;
		}
		
		for(int i=0; i<N; i++) {
			if( array[i] >= target ) {
				result[depth] = array[i];
				dfs(depth + 1, array, array[i], result);
			}
		}
	}

}
