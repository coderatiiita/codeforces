package com.patterns.array;

import java.util.Scanner;

public class ArithmeticArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum=0;

            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }

            if(sum == n) {
                System.out.println(0);
            } else if(sum < n) {
                //int diff = n-sum;
                System.out.println(1);
            } else { // sum > n
                System.out.println(sum-n);
            }
        }
    }

}