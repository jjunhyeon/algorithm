package array;

import java.util.Scanner;
/*
* 소수 구하기
* 입력받은 파라미터까지의 값 중 소수의 개수를 출력한다.
* ++
* 검사할 배열의 사이즈를 s+1만큼 가져가 설정해야한다
* : 그렇게 해야 s까지의 값을 검사할 배열에 값을 담을 수 있기 때문이다
* ++
* 값이 배수인지 아닌지 검사할때 for문의 i씩 값을 증가시켜 검사해야 배수의 값을 확인할 수 있다.
* */
public class Sosu_20230308 {
    // 실제 Solution
    static class Main {
        public int solution(int s) {
            int result =0;
            int[] target = new int[s+1];

            for(int i=2; i<s; i++){
                if(target[i] == 0){
                    result ++;
                    for(int j=i; j<=s; j=j+i){
                        target[j] =1;
                    }
                }
            }

            return result;
        }
    }
        /*
         * 값 입력받기
         * */
        public static void main(String[] args) {
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int s = kb.nextInt();
            System.out.println(T.solution(s));
        }
    }
