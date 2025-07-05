class Solution {
    public int solution(int storey) {
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

        while(tar != 0){
            if (tar >= 5) {
                tar = tar + 1;
            } else if (tar < 5) {
                tar = tar - 1;
            }
            result++;
        }
        return result;
    }
}