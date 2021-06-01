package com.example.dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Party {

  static Set<Integer> visited = new HashSet<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    int[] manager = new int[n];
    for (int i = 0; i < n; i++) {
      int t = sc.nextInt();
      manager[i] = t == -1 ? - 1 : t-1;
    }
    int maxDepth = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (!visited.contains(i)) {
        maxDepth = Math.max(maxDepth, dfs(manager, n, i));
      }
    }
    System.out.println(maxDepth);
  }

  private static int dfs(int[] manager, int n, int i) {
    visited.add(i);
    if (i == -1) {
      return 0;
    }
    return dfs(manager, n, manager[i]) + 1;
  }
}