package com.pass.boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class DualPriorityQueue_7662_TreeSet_20230625 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        int tCases = Integer.parseInt(bf.readLine());
        while (tCases-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int arrCount = Integer.parseInt(st.nextToken());
            for (int i = 0; i < arrCount; i++) {
                String[] info = bf.readLine().split(" ");
                int num = Integer.parseInt(info[1]);
                switch (info[0]) {
                    case "D":
                        if (!tMap.isEmpty()) {
                            if (num == 1 && tMap.lastEntry().getValue() == 1) { // 최대값 삭제
                                tMap.remove(tMap.lastKey());
                            } else if (num == 1 && tMap.lastEntry().getValue() > 1) {
                                Map.Entry<Integer, Integer> lastEntry = tMap.lastEntry();
                                int originalValue = lastEntry.getValue();
                                int decreasedValue = originalValue - 1;
                                tMap.put(lastEntry.getKey(), decreasedValue);
                            } else if (num == -1 && tMap.firstEntry().getValue() == 1) {
                                tMap.remove(tMap.firstKey());
                            } else if (num == -1 && tMap.firstEntry().getValue() > 1) {
                                Map.Entry<Integer, Integer> firstEntry = tMap.firstEntry();
                                int originalValue = firstEntry.getValue();
                                int decreasedValue = originalValue - 1;
                                tMap.put(firstEntry.getKey(), decreasedValue);
                            }
                        }
                        break;
                    case "I":
                        tMap.put(num, tMap.size() + 1);
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
