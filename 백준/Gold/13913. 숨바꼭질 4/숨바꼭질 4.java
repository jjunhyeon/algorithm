
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 수빈이의 위치가 X일떄 -1 또는 +1로 이동하거나
// 순간이동을 하는 경우 2 * 현재위치(X) 로 이동하게 된다.
// 수빈이와 동생의 위치가 주어졌을때 수빈이가 동생을 찾을 수 있는 가장 빠른 시간을 구해야한다.
// 1 - IF WALK ) 4 6  IF TP 10
// 2 - IF WALK ) 3,5 5,7, 9,11  >>> IF TP ) 8 12 20  
// 3-  IF WALK ) 2,4  4,6  4,6 6,8  8,10 10,12     7,9 11,13 19,21     >>>>> TP 6,10,14,18,22, 16, 24 ,40 
// 4-  IF WALK ) 1,3 3,5 3,5 5,7..... >>> 5,7 9,11 13,15 VVVV -- 17(FOUND) -- VVVV  ,19 
// dfs로 탐색하면서 찾기
public class Main {
	static int[] condition = { 1, -1, 2 };
	static int start, target;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		if(start > target) printDecreasingPath(start, target);
		else bfs();
	}

	private static void printDecreasingPath(int start2, int target2) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(String.valueOf(start - target)).append("\n");  
        for (int i = start; i >= target; i--) {
            if(i == target)bw.append(String.valueOf(i));
            else bw.append(i + " ");  // 경로 출력
        }
        bw.flush();
        bw.close();
	}

	// start 값을 기준으로 target 까지의 걸리는 시간을 찾는다.
	private static void bfs() throws IOException {
		Queue<int[]> myQ = new LinkedList<>();
		HashSet<Integer> check = new HashSet<>();
		HashMap<Integer, Integer> parentMap = new HashMap<>(); // 노드의 이전 값을 추적
		
	    // 최대 탐색 범위 설정
	    int maxLimit = Math.max(start, target) * 2;
		// q에 현재값과 depth 정보를 담는다.
		// 결국 depth를 파악해야하므로
		myQ.add(new int[] { start, 0 });
		check.add(start);
		parentMap.put(start, -1);  // 시작점의 이전 노드는 없으므로 -1로 설정
		
		while (!myQ.isEmpty()) {
			int[] curInfo = myQ.poll();
			int cur = curInfo[0];
			int curLevel = curInfo[1];
			
			if (cur == target) {
	            // 경로 출력하기 (역추적)
				printPath(parentMap, cur);
				break;
			}

			// move 조건은 3가지임
			for (int i = 0; i < 3; i++) {
				int nextX = (i != 2 ? cur + condition[i] : cur * condition[i]);
				
				if (nextX >= 0 && nextX <= maxLimit && !check.contains(nextX)) {
					myQ.add(new int[] { nextX, curLevel + 1 });
					check.add(nextX);
					parentMap.put(nextX, cur);  // 현재 값의 부모로 cur 저장
				}
			}
		}
	}
	
	// 경로를 역추적하여 출력하는 함수
	private static void printPath(HashMap<Integer, Integer> parentMap, int target) throws IOException {
	    LinkedList<Integer> path = new LinkedList<>();
	    int cur = target;
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    // 부모를 추적하면서 경로를 저장
	    while (cur != -1) {
	        path.addFirst(cur);  // 경로를 역순으로 저장
	        cur = parentMap.get(cur);  // 부모 노드로 이동
	    }
	    StringBuilder sb = new StringBuilder();
	    int len = path.size();
	    sb.append(len - 1).append("\n");  // 걸린 시간을 먼저 저장
	    
	    // 마지막 띄어씌기 삭제
	    //sb.deleteCharAt(sb.length()-1);
	    for(int i=0; i<len; i++) {
	    	sb.append(path.get(i)).append(" ");
	    }
	    bw.write(sb.toString());
	    bw.flush();
	    bw.close();
	}
}
