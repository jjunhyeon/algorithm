
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        while(T --> 0){
            StringBuilder sb = new StringBuilder();
            String[] info = bf.readLine().split(" ");
            int M = Integer.parseInt(info[0]);
            String target = info[1];

            for(int i=0; i< target.length(); i++){
                for(int j=0; j<M; j++){
                    sb.append(String.valueOf(target.charAt(i)));
                }
            }
            System.out.println(sb);
        }

        bf.close();
    }
}
