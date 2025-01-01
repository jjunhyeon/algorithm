package programmers.level2;

/*
 * 마법의 엘리베이터
 * 경우의수 조지기
 * */
public class 마법엘베_148653 {
    public static void main(String[] args) {
        //param1
        int storey = 545;
        int result = solution(storey);
        System.out.println("result" + result);
    }

    public static int solution(int storey) {
        int result = 0;
        int length = storey / 10;
        // lenght -> 1
        for (int i = 1; i <= length; i++) {

            if(storey == 0){
                break;
            }
            int division = (int) Math.pow(10, i);
            int upNumber = storey % (int) Math.pow(10, i + 1);
            int target = storey % division;

            if (target != 0) {
                while (target >= 10) {
                    target /= 10;
                }
            }

            if (upNumber != 0) {
                if(division > upNumber){
                    upNumber =0;
                } else {
                    while (upNumber >= 10) {
                        upNumber /= 10;
                    }
                }
            }

            while (target % 10 != 0) {
                if (target > 5 || (target == 5 && upNumber >= 5)) {
                    target = target + 1;
                    storey += (1 * division / 10) ;
                    result++;
                } else if (target < 5 || target == 5) {
                    target = target - 1;
                    storey -= (1 * division / 10);
                    result++;
                }
            }
        }

        int tar = storey / (int) Math.pow(10, length);

        while(tar != 0 || tar != 10){
            if (tar >= 5) {
                tar = tar + 1;
            } else if (tar < 5) {
                tar = tar - 1;
            }
            return tar == 10 ? result+2 : result++;
        }
        return result;
    }
}
