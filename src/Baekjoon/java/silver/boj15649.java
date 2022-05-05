package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class boj15649 {
    static StringBuilder sb = new StringBuilder();
    static int[] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        answer = new int[M];
        boolean[] checked = new boolean[N];
        dfs(N,M,checked,0);

        System.out.println(sb.toString());
    }

    private static void dfs(int N,int M,boolean[] checked,int cnt){
        if(cnt==M){
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!checked[i]){
                answer[cnt]= i+1;
                checked[i] = true;
                dfs(N,M,checked,cnt+1);
                checked[i]= false;
            }
        }
    }
}
