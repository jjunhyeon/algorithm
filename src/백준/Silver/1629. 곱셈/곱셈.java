

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int targetNumber = Integer.parseInt(st.nextToken());
        int multipleNumber = Integer.parseInt(st.nextToken());
        int divideNumber = Integer.parseInt(st.nextToken());
        long result = getResultLongNumber(targetNumber, multipleNumber, divideNumber);
        System.out.println(result);
    }

    private static long getResultLongNumber(int targetNumber, int multipleNumber, int divideNumber) {

        if(multipleNumber == 0){
            return 1;
        }

        if(multipleNumber == 1){
            return targetNumber % divideNumber;
        }

        long longNumber = getResultLongNumber(targetNumber, multipleNumber / 2, divideNumber);
        if(multipleNumber % 2 == 0){
            return longNumber * longNumber % divideNumber;
        } else {
            return (longNumber * longNumber % divideNumber) * targetNumber % divideNumber;
        }

    }
}
