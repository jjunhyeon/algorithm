
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 비밀번호 찾기
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] counts = br.readLine().split(" ");
        int infoCount = Integer.parseInt(counts[0]);
        int pCount =  Integer.parseInt(counts[1]);
        String[] passwordInfo = new String[pCount];

        String[] domain = new String[pCount];
        String[] password = new String[pCount];

        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < infoCount; i++) {
            String[] st = br.readLine().split(" ");
            map.put(st[0], st[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pCount; i++) {
            String p = br.readLine();
            sb.append(map.get(p)).append('\n');
        }
        System.out.println(sb);
    }
}
