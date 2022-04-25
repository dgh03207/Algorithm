package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2110 {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);
        int prev = houses[0];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            int gap = houses[i]-prev;
            min = Math.min(min,gap);
            prev = houses[i];
        }

        int answer = 0;
        int max = houses[N-1]-houses[0];

        if(C==2){
            answer = max;
        }else {
            int left = min;
            int right = max;
            while(left<=right){
                int mid = (left+right)/2;
                prev = houses[0];
                int cnt = 1;
                for (int j = 1; j < N; j++) {
                    int distance = houses[j]-prev;
                    if(cnt==C) break;
                    if(distance>=mid){
                        prev = houses[j];
                        cnt+=1;
                    }
                }
                if(cnt>=C){
                    left = mid+1;
                    answer = mid;
                }else{
                    right = mid-1;
                }

            }
        }
        System.out.println(answer);


    }
}
