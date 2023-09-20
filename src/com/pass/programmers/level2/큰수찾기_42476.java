package com.pass.programmers.level2;
import java.util.*;

public class 큰수찾기_42476 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
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

            if (this.len >= 2) {
                this.headValue = this.value / (int) Math.pow(10, this.len - 1);
            }

            if (o.len >= 2) {
                o.headValue = o.value / (int) Math.pow(10, o.len - 1);
            }

            if (o.value == 0) {
                // -1 -> 우선순위 뒤
                return -1;
            }
            // 그다음 자릿수와 비교를 해야함
            if (o.headValue == this.headValue) {
                // headValue가 같은게 문제임, 정렬의 우선순위를 찾기 위함.
                int oLen = (o.len > 1) ? o.len - 1 : 1;
                int thisLen = (this.len > 1) ? this.len - 1 : 1;
                while (o.headValue == this.headValue || (thisLen < 1 && oLen < 1)) {
                    if (oLen > 0) {
                        if (oLen == 1) {
                            o.headValue = o.value % (int) Math.pow(10, oLen);
                        } else {
                            o.value = o.value % (int) Math.pow(10, oLen);
                            oLen--;
                            o.headValue = o.value / (int) Math.pow(10, oLen);
                        }
                    }

                    if (thisLen > 0) {
                        if (thisLen == 1) {
                            this.headValue = this.value % (int) Math.pow(10, thisLen);
                        } else {
                            this.headValue = this.value % (int) Math.pow(10, thisLen);
                            thisLen--;
                            this.headValue = this.value / (int) Math.pow(10, thisLen);
                        }
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
