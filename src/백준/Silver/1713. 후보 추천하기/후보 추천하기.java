
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int PICTURE_COUNT = Integer.parseInt(bf.readLine());
		int RECOMMEND_COUNT = Integer.parseInt(bf.readLine());
		int[] PICTURE_ARRAY = new int[RECOMMEND_COUNT];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < RECOMMEND_COUNT; i++) {
			PICTURE_ARRAY[i] = Integer.parseInt(st.nextToken());
		}
		Map<Integer, Integer> linkedMap = new LinkedHashMap<>();

		for (int i = 0; i < RECOMMEND_COUNT; i++) {
			int recommendStudent = PICTURE_ARRAY[i];
			if (linkedMap.containsKey(recommendStudent)) {
				linkedMap.put(recommendStudent, linkedMap.get(recommendStudent) + 1);
			} else {
				// PICUTRE_COUNT 검사
				if (linkedMap.size() >= PICTURE_COUNT) {
					int targetKey = 0;
					int temp =Integer.MAX_VALUE;
					for (Integer map : linkedMap.keySet()) {
						if(linkedMap.get(map) < temp) {
							temp = linkedMap.get(map);
							targetKey = map;
						}
					}
					linkedMap.remove(targetKey);
				}
				linkedMap.put(recommendStudent, 1);
			}
		}
		
		List<Integer> answerList = new ArrayList<>(linkedMap.keySet());
		Collections.sort(answerList);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<answerList.size(); i++) {
			if(i == answerList.size() - 1 ) sb.append(answerList.get(i));
			else sb.append(answerList.get(i) + " ");
		}
		System.out.println(sb);
	}
}
