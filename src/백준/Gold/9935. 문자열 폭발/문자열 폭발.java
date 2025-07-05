
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String st = bf.readLine();
        String bombCondition = bf.readLine();
        int bombSize = bombCondition.length();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<st.length(); i++){
            sb.append(st.charAt(i));
            if(sb.length() >= bombSize){
                boolean flag = true;
                for(int j=0; j<bombSize; j++){
                    char first = sb.charAt(sb.length() - bombSize + j);
                    char second = bombCondition.charAt(j);
                    if(first != second){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    sb.delete(sb.length() - bombSize, sb.length());
                }
            }
        }
        
        System.out.println(sb.length() ==0  ? "FRULA" : sb.toString());
    }
}
