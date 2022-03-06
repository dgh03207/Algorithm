package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//계단오르기
public class boj2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        int[][] dp = new int[N][2];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        int now = N - 1;
        dp[now][0] = scores[now];
        dp[now][1] = scores[now];
        int answer = 0;
        if (N > 1) {
            while (now >= 0) {
                if (now >= 2) {
                    if (dp[now][0] != -1 && dp[now][0] + scores[now - 2] > dp[now - 2][0]) {
                        dp[now - 2][0] = dp[now][0] + scores[now - 2];
                    }
                    if (dp[now][1] != -1 && dp[now][1] + scores[now - 2] > dp[now - 2][0]) {
                        dp[now - 2][0] = dp[now][1] + scores[now - 2];
                    }
                }
                if (now >= 1) {
                    if (dp[now][0] != -1 && dp[now][0] + scores[now - 1] > dp[now - 1][1]) {
                        dp[now - 1][1] = dp[now][0] + scores[now - 1];
                    }
                }
                now -= 1;
            }
            answer = Math.max(Math.max(dp[0][0], dp[0][1]), Math.max(dp[1][0], dp[1][1]));
        }else{
            answer = scores[0];
        }
        System.out.println(answer);
    }
}
