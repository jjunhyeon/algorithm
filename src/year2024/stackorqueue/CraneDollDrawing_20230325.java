package src.year2024.stackorqueue;

import java.util.Scanner;
import java.util.Stack;

/*
* 크레인 인형뽑기
* 문제 분석:
* 1. 2차원 배열의 숫자가 의미하는 것은 인형의 타입이라고 생각하면 될 것 같다.
* 2. 크레인의 움직임을 의미하는 파라미터가 크레인의 움직임을 의미하며 그 값을 순서로 2차원 배열의 인형을 뽑는다.
* 3. 뽑은 인형을 바구니에 담는 문제인데, 같은 타입의 인형을 담았다면 들어있는 인형과 크레인이 뽑은 인형 둘 다 사라진다.
* 4. 최종 사라진 인형의 갯수를 리턴하면 된다.
*
* */
public class CraneDollDrawing_20230325 {
    // 실제 Solution
    static class Main {
            public int solution(int[][] doubleArray, int[] oneArray) {
                int result = 0;
                Stack<Integer> busket = new Stack<>();

                for(int i=0; i<oneArray.length; i++){

                    int target = oneArray[i];
                    int lt = 0;
                    while(lt < doubleArray.length) {
                        int pick = doubleArray[lt][target - 1];
                        if (pick != 0) {
                            doubleArray[lt][target - 1] = 0;
                            if (!busket.isEmpty() && busket.peek().equals(pick)) {
                                result += 2;
                                busket.pop();
                            } else {
                                busket.push(pick);
                            }
                            break;
                        } else {
                            lt ++;
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
        int doubleArraySize = kb.nextInt();

        int[][] doubleArray = new int[doubleArraySize][doubleArraySize];

        for(int i=0; i<doubleArraySize; i++){
            for(int j=0; j<doubleArraySize; j++){
                doubleArray[i][j] = kb.nextInt();
            }
        }

        int oneArraySize = kb.nextInt();
        int[] oneArray = new int[oneArraySize];
        for(int k=0; k<oneArraySize; k++){
            oneArray[k] = kb.nextInt();
        }

        System.out.println(T.solution(doubleArray,oneArray));
    }
}
