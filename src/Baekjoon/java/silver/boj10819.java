package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10819 {
    static int max,N,nums[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = -10000;
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] checked = new boolean[N];
        int[] ordered = new int[N];
        dfs(0,checked,ordered);
        System.out.println(max);

    }

    private static void dfs(int idx, boolean[] checked,int[] ordered){
       if(idx==N){
           int prev = ordered[0];
           int result = 0;
           for (int i = 1; i < N; i++) {
               result += Math.abs(nums[prev]-nums[ordered[i]]);
               prev = ordered[i];
           }
           if(max<result) max = result;
       }

        for (int i = 0; i < N; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            ordered[idx] = i;
            dfs(idx+1,checked,ordered);
            checked[i] = false;
        }
    }
}
