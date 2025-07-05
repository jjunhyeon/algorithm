
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	 static int N;
	 static int price[]; // 각 물약의 가격
	 static int sale[][]; // 각 물약을 구매할 때 할인되는 정보
	 static int answer = Integer.MAX_VALUE; // 물약을 가장 싸게 살 때 필요한 최소 비용
	 static boolean visited[]; // 물약을 방문했는지 여부를 저장하는 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		price = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            price[i] = Integer.parseInt(st.nextToken()); // 각 물약의 가격 입력
        }
        
        sale = new int[N+1][N+1]; // 물약 할인 정보를 저장할 배열 초기화
        for (int i = 1; i < N+1; i++) {
            int p = Integer.parseInt(br.readLine()); // 물약 할인 정보의 개수 입력
            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                int salePrice = Integer.parseInt(st.nextToken());
                sale[i][idx] = salePrice; // 물약을 구매하면 할인되는 정보 입력
            }
        }
        
        visited = new boolean[N+1]; // 방문 여부를 저장하는 배열 초기화
        findMinCost(0, 0); // 가장 싸게 물약을 살 때 필요한 최소 비용을 찾는 메서드 호출
        System.out.println(answer); // 최소 비용 출력
	}
	
	
	private static void findMinCost(int depth, int curCost) {
		if(curCost >= answer) return; // 지금 비용이 최소 비용을 넘어가면 더 이상 탐색 필요 없음
		if(depth == N) {
			answer = Math.min(curCost, answer); // 현재 비용과 최소 비용을 비교하여 더 작은 값을 최소 비용으로 갱신
            return;
		}
		
		for(int i=1; i<N+1; i++) { //물약에 대해 반복
			if(visited[i]) continue;
			visited[i] = true;
            int originPrice[] = Arrays.copyOf(price, N+1); // 물약을 구매하기 전의 가격을 저장
            for (int j = 1; j < N+1; j++) { // 해당 물약을 구매하고 나서 할인되는 물약들에 대해 반복
                if(price[j] - sale[i][j] <=0 ){ // 할인되는 가격이 물약의 가격보다 크면
                    price[j] = 1; // 가격을 1로 설정 (가격은 0 이하는 되지 않음)
                } else { // 그렇지 않으면
                    price[j] -= sale[i][j]; // 할인된 가격으로 업데이트
                }
            }
            findMinCost(depth+1, curCost+price[i]); // 다음 물약을 선택하고 재귀적으로 호출
            price = Arrays.copyOf(originPrice, N+1); // 물약을 구매하기 전의 가격으로 되돌림
            visited[i] = false; // 현재 물약 방문 표시 해제
		}
	}
}
