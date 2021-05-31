package com.example.dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class HitTheLottery {

    static int[] denoms = {1, 5, 10, 20, 100};
    static int[] memo;
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println(minBillsReq(n));
    }

    private static int minBillsReq(int n) {
        for(int i=0; i<=n; i++) {
            if(i==0) {
                memo[i] = 0;
            } else {
                for(int j=denoms.length-1; j>=0; j--) {
                    if(denoms[j] <= i) {
                        memo[i] =  memo[i-denoms[j]] + 1;
                        break;
                    }
                }
            }
        }

        return memo[n];
    }

}
