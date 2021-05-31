package com.example.dp;

import java.util.Scanner;

public class EvenSubsetSum {

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            int[] nums = new int[n];
            boolean isEvenPresent = false;
            int even=0;
            for(int i=0; i<n; i++) {
                nums[i] = sc.nextInt();
                if(nums[i] %2 == 0) {
                    isEvenPresent = true;
                    even = i+1;
                }
            }
            if(isEvenPresent) {
                System.out.printf("1\n%d\n", even);
                continue;
            }
            if(n==1) {
                System.out.println("-1");
                continue;
            }
            System.out.println("2");
            System.out.println("1 2");
        }
    }
}
