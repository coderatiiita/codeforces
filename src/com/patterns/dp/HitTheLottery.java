package com.patterns.dp;

import java.util.Scanner;

public class HitTheLottery {

    static int[] denoms = {1, 5, 10, 20, 100};
    static int[] memo;
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println(minBillsReq(n));
    }

    private static int minBillsReq(int n) {
        int count=0;
        while(n > 0) {
            for(int j=denoms.length-1; j>=0; j--) {
                while(n>0 && denoms[j] <= n) {
                    n -= denoms[j];
                    count++;
                }
            }
        }

        return count;
    }

}
