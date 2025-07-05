import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
* 패션왕 신해빈(9375번)
*
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        while(T --> 0){
            int result = 1;
            int type = Integer.parseInt(bf.readLine());
            // 의상 정보를 담은 map 정보
            Map<String, Integer> fashion = new HashMap<>();
            for(int i=0; i<type; i++){
                String[] info = bf.readLine().split(" ");
                if (fashion.containsKey(info[1])) {
                    fashion.put(info[1], fashion.get(info[1]) + 1);
                }
                else {
                    fashion.put(info[1], 1);
                }
            }

            for(int val :fashion.values()){
                result *= (val+1);
            }

            sb.append(result-1).append("\n");
        }
        System.out.println(sb);
    }
}
