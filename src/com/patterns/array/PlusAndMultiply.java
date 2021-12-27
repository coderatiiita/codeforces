package com.patterns.array;

import java.util.Scanner;

//  𝑥⋅𝑎  and 𝑥+𝑏

public class PlusAndMultiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            long n, a, b;
            n = sc.nextLong();
            a = sc.nextLong();
            b = sc.nextLong();

            if(b==1 || n==1) {
                System.out.println("Yes");
            } else {
                if(a==1) {
                    if((n-1)%b == 0) {
                        System.out.println("Yes");
                    } else System.out.println("No");
                } else {
                    long k = 1;
                    while(k <= n) {
                        if((n-k) % b == 0) {
                            System.out.println("Yes");
                            break;
                        }
                        k = k*a;
                    }
                    if(k>n) System.out.println("No");
                }
            }
        }
    }

}
