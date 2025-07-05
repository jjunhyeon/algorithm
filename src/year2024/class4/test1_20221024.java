package src.year2024.class4;

import java.util.Scanner;

public class test1_20221024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("찍을 *의 수를 입력하세요");
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j=n-i; j<=n; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
