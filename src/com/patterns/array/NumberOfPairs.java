package com.patterns.array;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfPairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long l = sc.nextLong();
            long r = sc.nextLong();

            long[] nums = new long[n];
            for(int i=1; i<=n; i++) {
                nums[i-1] = sc.nextLong();
            }

            Arrays.sort(nums);

            long count=0;

            for(int i=n-1; i>0; i--) {
                long a = nums[i];

                long x1=-1;
                long left=0, right=i-1;
                while(left<=right) {
                    long mid = left + (right-left)/2;
                    if(nums[(int)mid] + a >= l) {
                        x1 = mid;
                        right=mid-1;
                    } else {
                        left = mid+1;
                    }
                }

                if(x1 == -1)    continue;

                long x2=-1;
                left=x1; right=i-1;
                while(left<=right) {
                    long mid = left + (right-left)/2;
                    if(nums[(int)mid] + a <= r) {
                        x2 = mid;
                        left = mid+1;
                    } else {
                        right = mid-1;
                    }
                }

                if(x2==-1)  continue;

                count += x2 - x1 + 1;
            }

            System.out.println(count);
        }
    }

}