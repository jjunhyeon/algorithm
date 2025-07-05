package src.year2024.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
* 비밀번호 찾기
* */
public class Password_17219_20230612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] counts = br.readLine().split(" ");
        int infoCount = Integer.parseInt(counts[0]);
        int pCount =  Integer.parseInt(counts[1]);

        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < infoCount; i++) {
            String[] st = br.readLine().split(" ");
            map.put(st[0], st[1]);
        }

        StringBuilder sb = new StringBuilder(); // String Builder를 활용해 문자열을 수정하는것이 성능적으로 더 효율적이다.
        for (int i = 0; i < pCount; i++) {
            String p = br.readLine();
            sb.append(map.get(p)).append('\n');
        }
        System.out.println(sb);
    }
}
