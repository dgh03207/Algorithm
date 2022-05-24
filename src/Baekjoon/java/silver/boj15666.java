package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj15666 {
    static int N,M,nums[];
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        nums = Arrays.stream(nums).distinct().sorted().toArray();
        N = nums.length;
        dfs(0,new int[M],0);
        System.out.println(sb.toString());
    }

    public static void dfs(int idx,int[] sequence,int start){
        if(idx==M){
            Arrays.sort(sequence);
            for (int i = 0; i < M; i++) {

                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            sequence[idx] = nums[i];
            dfs(idx+1,sequence,i);
        }
    }
}
