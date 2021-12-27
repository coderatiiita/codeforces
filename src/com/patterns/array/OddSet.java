package com.patterns.array;

import java.util.Scanner;

public class OddSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int oddCount=0, evenCount=0;
            for(int i=0; i<2*n; i++) {
                int temp = sc.nextInt();
                if(temp % 2 == 0) {
                    evenCount++;
                } else oddCount++;
            }

            if(evenCount == oddCount) {
                System.out.println("Yes");
            } else System.out.println("No");
        }
    }
}
