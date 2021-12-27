package com.patterns.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransformationAtoB {

  static long a, b;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    a = sc.nextLong();
    b = sc.nextLong();
    List<Long> path = new ArrayList<>();
    if(dfs(a, path)) {
      System.out.printf("YES\n%d\n", path.size());
      path.forEach(e -> System.out.printf("%d ", e));
    } else {
      System.out.println("NO");
    }
  }

  private static boolean dfs(long pos, List<Long> path) {
    if(pos > b) return false;
    path.add(pos);
    if(pos == b) return true;
    if(dfs(10*pos+1, path) || dfs(pos*2, path))  return true;
    path.remove(path.size()-1);
    return false;
  }

}
