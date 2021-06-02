package com.example.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NotAdjacentMatrix {

    static Map<Integer, String> mp = new HashMap<>();

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            if(mp.containsKey(n)) {
                System.out.print(mp.get(n));
                continue;
            }
            if(n==2) {
                System.out.println("-1");
            } else {
                int num=1, numRev = n*n - n*n/2 +1;
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<n; i++) {
                    for(int j=0; j<n; j++) {
                        if((i+j)%2 == 0) {
                            System.out.printf("%d ", num);
                            sb.append(num++);
                            sb.append(' ');
                        } else {
                            System.out.printf("%d ", numRev);
                            sb.append(numRev++);
                            sb.append(' ');
                        }
                    }
                    sb.append('\n');
                    System.out.println();
                }
                mp.put(n, sb.toString());
            }
        }
    }

    private static boolean bt(int[][] matrix, int n, int num) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == -1) {
                    if(isValid(i, j, matrix, num, n)) {
                        matrix[i][j] = num;
                        if(num == n*n)  return true;
                        if(bt(matrix, n, num+1))    return true;
                        matrix[i][j] = -1;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isValid(int i, int j, int[][] matrix, int num, int n) {
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};
        for(int k=0; k<4; k++) {
            int[] newPos = new int[]{i+dirX[k], j+dirY[k]};
            if(newPos[0] >= 0 && newPos[0] < n && newPos[1] >= 0 && newPos[1] < n) {
                if(matrix[newPos[0]][newPos[1]] != -1 && Math.abs(matrix[newPos[0]][newPos[1]] - num) == 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
