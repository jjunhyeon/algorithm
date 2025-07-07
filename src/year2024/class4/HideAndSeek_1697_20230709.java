package year2024.class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek_1697_20230709 {

    static int[] moved = {-1,1,2};
    static int[] answer = new int[1000001];
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int startNumber = kb.nextInt();
        int targetNumber = kb.nextInt();
        answer[startNumber] = 1;
        System.out.println(bfs(startNumber,targetNumber));
    }

    private static int bfs(int startNumber, int targetNumber) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNumber);
        while(!q.isEmpty()){
            int nowPlace = q.poll();

            if(nowPlace == targetNumber){
                return answer[nowPlace] - 1;
            }

            for(int i=0; i<3; i++){
                int movedPlace;
                if(moved[i] == 2){
                    movedPlace = nowPlace * moved[i];
                } else {
                    movedPlace = nowPlace + moved[i];
                }
                if(movedPlace >= 0  && movedPlace < 100000 && answer[movedPlace] == 0){
                    q.offer(movedPlace);
                    answer[movedPlace] = answer[nowPlace] +1;
                }
            }
        }
        return -1;
    }
}
