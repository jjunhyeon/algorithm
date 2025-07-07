package year2024.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
* 두 큐의 합
* */
public class MakeQueueEqual_118667_20230722 {
    public static void main(String[] args) {
        int[] param1 = new int[]{3,2,7,2};
        int[] param2 = new int[]{4,6,5,1};
        int result = solution(param1, param2);
        System.out.println("what si teh ans ::" + result);
    }

    public static int solution(int[] arr1, int[] arr2) {

        long sum = 0;
        Queue<Integer> firstQ = new LinkedList<Integer>();
        Queue<Integer> secondQ = new LinkedList<Integer>();

        for(int i=0; i<arr1.length; i++){ // 두 arr의 사이즈는 같음
            firstQ.offer(arr1[i]);
            secondQ.offer(arr2[i]);
        }

        long qSum =0;
        long nSum =0;

        for(Integer item : firstQ){
            qSum += item;
        }

        for(Integer num : secondQ){
            nSum += num;
        }

        sum = qSum + nSum;
        // sum을 절반으로 기준 만듬
        if(sum % 2 != 0){  // 차단
            return -1;
        } else { 
            sum = sum / 2 ;
        }

        int answer = 0;
        // while문 두큐의합이 모두 sum / 2 가 될 때까지
        while(qSum != nSum){ // -1 이 나오는 조건은?
            answer++;
            if(qSum < sum){
                int target = secondQ.poll();
                qSum += target;
                nSum -= target;
                firstQ.offer(target);
            } else {
                int target = firstQ.poll();
                qSum -= target;
                nSum += target;
                secondQ.offer(target);
            }

            if(answer > (arr1.length  + arr2.length) * 2){ // -1 처리
                return -1;
            }
        }
        return answer;
    }
}
