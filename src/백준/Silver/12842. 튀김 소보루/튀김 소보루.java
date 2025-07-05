
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int S;
    public static int M;
    public static int[] EAT_TIME;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N은 영선이가 사온 튀김 소보루 개수, S는 영선이가 돌아왔을 때 남은 튀김 소보루 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		// 001 방에 있던 사람 수
		M = Integer.parseInt(br.readLine());
		EAT_TIME = new int[M];
		for (int i = 0; i < M; i++) {
			// 각 사람이 한 개 소보루 먹는 데 걸리는 시간
			EAT_TIME[i] = Integer.parseInt(br.readLine());
		}

		// 먹은 튀김 소보루 개수
		int eatenSoboru = N - S;
		int time = 0;

		int answer = 0;
		while(eatenSoboru > 0) {
			for(int i=0; i<M; i++) {
				if(time % EAT_TIME[i] == 0) {
					eatenSoboru --;
				}
				if(eatenSoboru == 0) {
					answer = i + 1;
					break;
				}
			}
			time ++;
		}
		System.out.println(answer);
	}

}
