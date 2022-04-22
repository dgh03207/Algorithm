package Baekjoon.java.silver;

import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class boj7795 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            Arrays.sort(B);
            int answer =0;
            int s = 0;
            int t = 0;
            while(s<N){
                if(t==M){
                    answer += t;
                    s+=1;
                }else{
                    if(A[s]<= B[t]){
                        s+=1;
                        answer += t;
                    }
                    else{
                        t+=1;
                    }
                }
            }

            sb.append(answer+"\n");
        }

        System.out.println(sb.toString());
    }
}
