package com.patterns.greedy;

import java.util.Scanner;

public class BadBoy {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();
    while(t-- > 0) {
      int n = scanner.nextInt(), m = scanner.nextInt(), i = scanner.nextInt(), j= scanner.nextInt();

      System.out.printf("%d %d %d %d\n", 1, 1, n, m);
    }
  }

}
