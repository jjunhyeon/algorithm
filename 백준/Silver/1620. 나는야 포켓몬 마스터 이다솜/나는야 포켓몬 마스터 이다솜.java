
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 포켓몬마스터 이다솜
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] counts = br.readLine().split(" ");
        int poCount = Integer.parseInt(counts[0]);
        int pCount =  Integer.parseInt(counts[1]);
        String[] problem = new String[pCount];

        HashMap<String, Integer> pokemonMap = new HashMap<>();
        String[] pokemonArr = new String[poCount + 1]; // 포켓몬은 1번부터 시작함

        for (int i = 1; i <= poCount; i++) {
            String pokemonName = br.readLine();
            pokemonMap.put(pokemonName, i);
            pokemonArr[i] = pokemonName;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pCount; i++) {
            String p = br.readLine();
            if (Character.isDigit(p.charAt(0))) {
                int num = Integer.parseInt(p);
                sb.append(pokemonArr[num]).append('\n');
            } else {
                sb.append(pokemonMap.get(p)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
