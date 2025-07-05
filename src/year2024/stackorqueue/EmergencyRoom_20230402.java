package src.year2024.stackorqueue;
import java.util.*;
/*
* 응급실
* : N명의 대기 환자 목록에 대해 위험도가 주어지는데
*  첫 줄에 자연수 N(5<=N<=100)과 M(0<=M<N) 주어질 때
*  M번째 환자가 몇 번째로 진료받는지 출력한다.
* 1. 제일 첫 환자는 0번재이다.
* 2. 두 번째 줄 값들은 접수한 순서대로 환자의 위험도(50<=위험도<=100)가 주어집니다.
* 풀이 )
* 1. 동일한 값에 대한 우선순위 처리를 위해 해당 문제는 위험도만으로 해결할 수 없다.
* -> Person Class 생성 후 M번째 환자에 대한 정보를 식별하기 위한 UserNumber와 위험도 정보인 riskValue를 가지고 있는 Class를 생성한다.
* FIXME 다시 해결
* 1. Q에 담긴 person 객체를 하나꺼내서 Q와 비교하며 우선순위가 더 높은것이 있따면 Q에 다시 넣는다.
* 2. 임시변수가 null이 아니라면 우선순위가 높은 사람이고 j가 해당 id와 일치한다면 answer를 리턴한다.
* 3. 일치하지 않는다면 다음 result를 증가시키고 다음 taget의 사용자로 넘긴다.
* */

public class EmergencyRoom_20230402 {
    static class Main {
        public int solution(int k, int j, int[] intArray) {
            int result = 0;
            Queue<Person> emergency =  new ArrayDeque<>();
            for(int i=0; i< intArray.length; i++){
                emergency.add(new Person(i,intArray[i]));
            }

            while(!emergency.isEmpty()){
                Person target = emergency.poll();
                for(Person q : emergency){
                    if(target.riskValue < q.riskValue){
                        emergency.offer(target);
                        target = null;
                        break;
                    }
                }

                if(target != null){
                    result++;
                    if(target.userSerialNumber == j){
                        return result;
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
        int k = kb.nextInt();
        int j = kb.nextInt();

        int[] intArray =  new int[k];

        for(int i=0; i<k; i++){
            intArray[i] = kb.nextInt();
        }

        System.out.println(T.solution(k,j,intArray));
    }

    static class Person {
        int userSerialNumber;
        int riskValue;

        public Person(int userSerialNumber, int riskValue){
            this.userSerialNumber = userSerialNumber;
            this.riskValue = riskValue;
        }
    }
}
