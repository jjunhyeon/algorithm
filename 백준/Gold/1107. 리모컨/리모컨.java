import java.util.ArrayList;
import java.util.Scanner;

/*
* 고장난 리모컨
* */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int brokenNumberCount = sc.nextInt();
        ArrayList<Integer> remote = new ArrayList<>();

        for(int i=0; i<brokenNumberCount; i++){
            remote.add(sc.nextInt());
        }

        int result = Math.abs(target - 100); //초기값 설정

        for(int i = 0; i <= 999999; i++) { // 완전 탐색
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0; j < len; j++) {
                if(remote.contains(str.charAt(j) - '0')) { //고장난 버튼을 눌러야 하면
                    isBreak = true;
                    break; //더 이상 탐색하지 않고 빠져나온다.
                }
            }
            if(!isBreak) { //i를 누를때 고장난 버튼을 누르지 않는다면
                int min = Math.abs(target - i) + len; //i를 누른 후(len) target까지 이동하는 횟수(target - i)
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}
