import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tCases = Integer.parseInt(bf.readLine());
        while (tCases-- > 0) {
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int arrCount = Integer.parseInt(st.nextToken());
            for (int i = 0; i < arrCount; i++) {
                String[] info = bf.readLine().split(" ");
                String type = info[0];
                int num = Integer.parseInt(info[1]);
                switch (type) {
                    case "D":
                        if (!tMap.isEmpty()) {
                        int key = num == 1 ? tMap.lastKey() : tMap.firstKey();
                        int cnt = tMap.get(key);
                            if (cnt == 1 ) { // key의 value가 단일 값이라면
                                tMap.remove(key);
                            } else { // 중복 값이 있다면 -> 새로 put한다.
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
