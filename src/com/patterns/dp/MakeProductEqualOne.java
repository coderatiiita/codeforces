package com.patterns.dp;

import java.util.Scanner;

public class MakeProductEqualOne {

    public static void main(String[] args) {
        int n, oneCount=0, minusOneCount=0, zeroes=0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] nums = new int[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            switch(nums[i]) {
                case 1: oneCount++; break;
                case -1: minusOneCount++; break;
                default:
                    if(nums[i] > 1) {
                        ans += nums[i] - 1;
                        oneCount++;
                    } else if(nums[i] < -1) {
                        ans += -1 - nums[i];
                        minusOneCount++;
                    } else {
                        zeroes++;
                    }
            }
        }
        if(zeroes > 0) {
            ans += zeroes;
        } else if(minusOneCount > 0 && minusOneCount%2 != 0) {
            ans += 2;
        }
        System.out.println(ans);
    }

}
