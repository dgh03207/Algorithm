package Baekjoon.java.gold;

import java.io.*;
import java.util.*;

public class boj3020 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        //A는 석순, B는 종유석
        int[] A = new int[H+1];
        int[] B = new int[H+1];
        for (int i = 0; i < N; i++) {
            if(i%2==0) {
                B[Integer.parseInt(br.readLine())]+=1;
            }else{
                A[Integer.parseInt(br.readLine())]+=1;
            }
        }
        int answer = 0;
        int minBroken = Integer.MAX_VALUE;

        //누적합 만들기
        for (int i = 1; i < H+1; i++) {
            A[H-i] = A[H-i]  +A[H-i+1];
            B[H-i] = B[H-i]  +B[H-i+1];

        }

        //
        for (int i = 1; i < H+1; i++) {
            int broken = A[i]+B[H-i+1];
            if(minBroken>broken){
                minBroken = broken;
                answer = 1;
            }else if(minBroken==broken){
                answer +=1;
            }
        }
        System.out.println(minBroken+" "+answer);
    }
}
