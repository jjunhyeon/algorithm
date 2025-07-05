
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * ATM
 * : 최소의 시간을 구하는 프로그램 만들기
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pCount = Integer.parseInt(br.readLine());
        ArrayList<Integer> minimumArray = new ArrayList<Integer>();
        int result[] = new int[pCount+1];
        String[] value = br.readLine().split(" ");
        for(int i=0; i<pCount; i++){
            minimumArray.add(Integer.parseInt(value[i]));
        }
        //  오름차순 정렬
        Collections.sort(minimumArray);

        // 초기값 set
        for(int i=1; i<=pCount; i++){
            for(int j=i-1; j>=0; j--){
                result[i] += minimumArray.get(j);
            }
        }

        int sum = 0;
        for(int i=1; i<result.length; i++){
            sum += result[i];
        }

        System.out.println(sum);
    }
}
