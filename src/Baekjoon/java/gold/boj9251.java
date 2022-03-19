package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj9251 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] target = br.readLine().split("");
        String[] result = br.readLine().split("");
        int[][] dp = new int[target.length+1][result.length+1];
        int answer = 0;
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if(target[i].equals(result[j])){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
                if(answer<dp[i+1][j+1]) answer = dp[i+1][j+1];
            }
        }

        System.out.println(answer);

    }
}
