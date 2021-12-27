package com.patterns.binarySearch;

import java.util.*;

public class OrdinaryNumbers {

    static List<Long> ordNums;

    public static void main(String[] args) {
        ordNums = new ArrayList<>();
        preProcess();
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while (t-- > 0) {
            long n;
            n = sc.nextLong();
            System.out.println(bsearch(n));

        }
    }

    private static int bsearch(long n) {
        int l=0, r=ordNums.size()-1;
        int ans=-1;
        while(l<=r) {
            int mid = l + (r-l) / 2;
            if(ordNums.get(mid) <= n) {
                ans = mid;
                l=mid+1;
            } else {
                r=mid-1;
            }
        }

        return ans != -1 ? ans+1 : 0;
    }

    private static void preProcess() {
        for(long i=1; i<=1_111_111_111; ) {
            for(long j=1; j<10; j++) {
                ordNums.add(j*i);
            }
            i = i*10+1;
        }
    }

}