package com.patterns.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Badge {

  static List<Integer> res = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    int[] blame = new int[n];
    for(int i=0; i<n; i++) {
      blame[i] = sc.nextInt() - 1;
    }
    solve(n, blame);
    res.forEach(e -> System.out.printf("%d ", e));
  }

  private static void solve(int n, int[] adjMat) {
    for(int i=0; i<n; i++) {
      dfs(n, adjMat, i, new HashSet<Integer>());
    }
  }

  private static void dfs(int n, int[] adjMat, int pos, Set<Integer> visited) {
    visited.add(pos);
    if(visited.contains(adjMat[pos])) {
      res.add(adjMat[pos]+1);
      return;
    }
    dfs(n, adjMat, adjMat[pos], visited);
  }
}
