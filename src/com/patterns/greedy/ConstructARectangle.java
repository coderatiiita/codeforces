package com.patterns.greedy;

import java.util.Scanner;

public class ConstructARectangle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int l1 = sc.nextInt(), l2 = sc.nextInt(), l3 = sc.nextInt();

            if(isPossible(l1, l2, l3) || isPossible(l2, l3, l1) || isPossible(l3, l2, l1)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isPossible(int l1, int l2, int l3) {
        if(l2 == l3) {
            return l1 % 2 == 0;
        } else {
            return l2+l3 == l1;
        }
    }
}
