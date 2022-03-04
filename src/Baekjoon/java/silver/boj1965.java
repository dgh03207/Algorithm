package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//상자넣기
public class boj1965 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] boxes = new int[N];
        int[][] dp = new int[N][2];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
            dp[i][0] = boxes[i];
            dp[i][1] = 0;
            if(dp[i][1]>answer)answer = dp[i][1];
        }

        for (int i = 0; i < N-1; i++) {
            int target = boxes[i];
            if(dp[i][1]>answer) answer = dp[i][1];
            for (int j = i+1; j < N; j++) {
                if(boxes[j]>target){
                    if(dp[j][1]<dp[i][1]+1){
                        dp[j][0] = target;
                        dp[j][1] = dp[i][1]+1;
                    }
                    else if(dp[j][1]==dp[i][1]+1&&dp[j][0]>target){
                        dp[j][0] = target;
                        dp[j][1] = dp[i][1]+1;
                    }
                }
            }
        }
        if(dp[N-1][1]>answer)answer = dp[N-1][1];
        System.out.println(answer+1);
    }
}
