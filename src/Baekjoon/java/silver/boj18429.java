package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj18429 {
    static int answer = 0;
    static int N,K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] kits = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] checked = new boolean[N];
        dfs(500,kits,checked,0);
        System.out.println(answer);
    }

    private static void dfs(int now,int[] kits,boolean[] checked,int cnt){
        if(cnt==N){
            answer+=1;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(checked[i]) continue;
            int weight = now+kits[i]-K;
            if(weight>=500){
                checked[i] = true;
                dfs(weight,kits,checked,cnt+1);
                checked[i] = false;
            }
        }
    }


}
