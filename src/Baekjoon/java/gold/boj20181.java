package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//참고 코드 : https://blog.naver.com/PostView.nhn?blogId=adamdoha&logNo=222147929582&categoryNo=67&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=search
public class boj20181 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long [] energy = new long[N];
        long []dp = new long[N];
        for (int i = 0; i < N; i++) {
            energy[i] = Long.parseLong(st.nextToken());
        }

        long sum=0;
        long prev_max = 0;
        int j = -1;
        for (int i = 0; i < N; i++) {
            while(j+1<N&&sum<K){
                sum+=energy[++j];
            }
            dp[j]=Math.max(dp[j],prev_max+Math.max(0,sum-K));
            sum-=energy[i];
            prev_max=Math.max(prev_max,dp[i]);
        }


        System.out.println(prev_max);
    }
}
