package src.year2024.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
/*
* TreeMap
* 주요 Method
* getOrDefault(x,y) : 지정된 키로 매핑된 값이 없는 경우 x에 매핑되어 있는 값을 반환하고 그렇지 않으면 y가 반환된다.
* lastKey : 가장 마지막 value (TreeMap은 key값으로 자동 정렬되므로 가장 큰 key값을 리턴한다.
* firstKey : lastKey의 반대 기능
* */
public class DualPriorityQueue_7662_TreeSet_20230625 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tCases = Integer.parseInt(bf.readLine());
        while (tCases-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int arrCount = Integer.parseInt(st.nextToken());
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            for (int i = 0; i < arrCount; i++) {
                String[] info = bf.readLine().split(" ");
                String type = info[0];
                int num = Integer.parseInt(info[1]);
                switch (type) {
                    case "D":
                        if (!tMap.isEmpty()) {
                        int key = num == 1 ? tMap.lastKey() : tMap.firstKey();
                        int cnt = tMap.get(key);
                            if (cnt == 1 ) { // 최대값 삭제
                                tMap.remove(key);
                            } else {
                                tMap.put(key, cnt-1);
                            }
                        }
                        break;
                    case "I":
                        tMap.put(num,  tMap.getOrDefault(num, 0) + 1);
                        break;
                }
            }

            if (tMap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(tMap.lastKey() + " " + tMap.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
