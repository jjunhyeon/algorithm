package src.year2024.class4;

import java.util.*;

/*
 * 잃어버린 괄호
 *
 * */
public class MissingBracket_1541_20230611 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String param = sc.nextLine();

        String[] arr = param.split("-");
        int ans =0;
        for(int i=0; i<arr.length; i++){
            int tmp =0;
            String[] st = arr[i].split("\\+");
            for(int j=0; j<st.length; j++){
                tmp += Integer.parseInt(st[j]);
            }
            if(i ==0){
                ans += tmp;
            } else{
                ans -= tmp;
            }
        }
        System.out.println(ans);
    }
}
