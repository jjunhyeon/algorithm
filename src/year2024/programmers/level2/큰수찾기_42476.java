package src.year2024.programmers.level2;
import java.util.*;

public class 큰수찾기_42476 {
    public static void main(String[] args) {
        int[] numbers = {12, 1213};
        //int[] numbers = {1101, 1};
        //int[] numbers = {110, 1};
        //int[] numbers = {8, 9, 88898};
        //int[] numbers = { 0,0,1};
        solution(numbers);
    }

    public static String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<CustomBigNumber> myIntegerQ = new PriorityQueue<CustomBigNumber>();

        for (final int item : numbers) {
            myIntegerQ.offer(new CustomBigNumber(item));
        }

        StringBuilder sb = new StringBuilder();
        while (!myIntegerQ.isEmpty()) {
            sb.append(myIntegerQ.poll());
        }

        answer = sb.toString();
        System.out.println("get answer ::" + answer);
        return answer;
    }

    public static class CustomBigNumber implements Comparable<CustomBigNumber> {
        int value;
        int len;
        int headValue;

        CustomBigNumber(int value) {
            this.value = value;
            this.len = (int) (Math.log10(value) + 1);
            if (value < 10) {
                this.headValue = value;
            }
        }

        @Override
        public int compareTo(CustomBigNumber o) {
            // 0은 우선순위 가장 뒤
            if (o.value == 0 ) {
                return -1;
            }
            // 초기 값, 길이에 따라 1보다 작으면 나머지로, 크면 몫으로 세팅
            this.headValue = (this.len > 1) ? this.value / (int) Math.pow(10, this.len - 1) : this.value % (int) Math.pow(10, this.len);
            o.headValue = (o.len > 1) ? o.value / (int) Math.pow(10, o.len - 1) : o.value % (int) Math.pow(10, o.len);

            // 그다음 자릿수와 비교를 해야함
            if (o.headValue == this.headValue) {
                // headValue가 같은게 문제임, 정렬의 우선순위를 찾기 위함.
                int oLen = (o.len > 1) ? o.len - 1 : 1;
                int thisLen = (this.len > 1) ? this.len - 1 : 1;
                
                // 비교를 위한 value 정보
                int tempValue = o.value;
                int tempThisValue = this.value;
                while (o.headValue == this.headValue ) {
                    if (oLen > 0) {
                        if (oLen == 1) {
                            o.headValue = tempValue % (int) Math.pow(10, oLen--);
                        } else {
                            tempValue = tempValue % (int) Math.pow(10, oLen--);
                            o.headValue = tempValue / (int) Math.pow(10, oLen);
                        }
                    }

                    if (thisLen > 0) {
                        if (thisLen == 1) {
                            this.headValue = tempThisValue % (int) Math.pow(10, thisLen--);
                        } else {
                            tempThisValue = tempThisValue % (int) Math.pow(10, thisLen--);
                            this.headValue = tempThisValue / (int) Math.pow(10, thisLen);
                        }
                    }

                    if(thisLen <= 0 && oLen <=0){
                        break;
                    }
                }
            }
            return Integer.compare(o.headValue, this.headValue);
        }

        @Override
        public String toString() {
            return Integer.toString(this.value);
        }
    }
}
