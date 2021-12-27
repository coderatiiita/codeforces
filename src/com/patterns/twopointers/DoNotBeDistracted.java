package com.patterns.twopointers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DoNotBeDistracted {

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            String tasks = sc.next();
            System.out.println(isSuspicious(n, tasks));
        }
    }

    private static String isSuspicious(int n, String tasks) {
        Set<Character> task = new HashSet<>();
        int i=0;
        while(i<n) {
            while(i<n-1 && tasks.charAt(i) == tasks.charAt(i+1)) {
                i++;
            }
            if(task.contains(tasks.charAt(i))) {
                return "NO";
            }
            task.add(tasks.charAt(i));
            i++;
        }
        return "YES";
    }
}