package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.lang.*;
import java.util.*;

public class boj2805 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        int left = 0;
        int right = trees[N-1];
        int answer = 0;
        while(left<=right){
            int mid = (left+right)/2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if(trees[i]>=mid) {
                    sum += trees[i] - mid;
                }
            }
            if(sum<M){
                right = mid-1;
            }else{
                answer = mid;
                left = mid+1;
            }
        }
        System.out.println(answer);
    }
}
