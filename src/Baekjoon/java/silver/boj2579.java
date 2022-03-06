package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//계단오르기
public class boj2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

    }

}
