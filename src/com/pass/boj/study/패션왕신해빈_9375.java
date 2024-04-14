package com.pass.boj.study;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : com.pass.boj.study
 * fileName       : 패션왕신해빈_9375
 * author         : kjh
 * date           : 2024-04-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-14        kjh       최초 생성
 */
public class 패션왕신해빈_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            int result = 1;
            int type = Integer.parseInt(bf.readLine());
            // 의상 정보를 담은 map 정보
            Map<String, Integer> fashion = new HashMap<>();
            for (int i = 0; i < type; i++) {
                String[] info = bf.readLine().split(" ");
                if (fashion.containsKey(info[1])) {
                    fashion.put(info[1], fashion.get(info[1]) + 1);
                } else {
                    fashion.put(info[1], 1);
                }
            }
            for (int val : fashion.values()) {
                result *= (val + 1);
            }
            bw.append(Integer.toString(result - 1)).append("\n");
        }
        bf.close();
        bw.close();
    }
}
