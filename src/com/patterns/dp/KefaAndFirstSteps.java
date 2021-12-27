package com.patterns.dp;

import java.util.Scanner;

public class KefaAndFirstSteps {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print(dp(nums, n));
    }

    private static int dp(int[] nums, int n) {
        int ans=1;
        int res=0;
        for(int right=1; right<n; right++) {
            if (nums[right] >= nums[right-1]) {
               ans++;
            } else {
                res = Math.max(ans, res);
                ans=1;
            }
        }
        return Math.max(ans, res);
    }

}
