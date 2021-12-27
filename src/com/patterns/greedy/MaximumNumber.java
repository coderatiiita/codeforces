package com.patterns.greedy;

import java.util.Scanner;

public class MaximumNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        if(n%2 == 0) {
            n = n/2;
            while (n-->0) {
                sb.append("1");
            }
            System.out.println(sb);
        } else {
            n -= 3;
            sb.append("7");
            n = n/2;
            while (n-->0) {
                sb.append("1");
            }
            System.out.println(sb);
        }
    }

}