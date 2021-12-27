package com.patterns.dp;

import java.util.Scanner;

public class FairDivision {

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            int[] nums = new int[n];
            int ones = 0, twos=0;
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                switch(nums[i]) {
                    case 1: ones++; break;
                    case 2: twos++; break;
                }
            }

            if(ones == 0) {
                if(twos == 0) {
                    System.out.println("YES");
                } else {
                    if(twos%2 == 0) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            } else {
                if(twos == 0) {
                    if(ones%2 == 0)
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                } else {
                    if(twos%2 == 0) {
                        if(ones%2 == 0)
                            System.out.println("YES");
                        else
                            System.out.println("NO");
                    } else {
                        if(ones%2 == 0)
                            System.out.println("YES");
                        else
                            System.out.println("NO");
                    }
                }
            }
        }
    }
}
