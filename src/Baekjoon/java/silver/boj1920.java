package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
import java.lang.*;

public class boj1920 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        List<BigInteger> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(new BigInteger(st.nextToken()));
        }
        Collections.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            BigInteger now = new BigInteger(st.nextToken());
            int right = N-1;
            int left = 0;
            boolean flag = false;
            while(left<=right){
                int mid = (right+left)/2;
                if(now.compareTo(arr.get(mid))==0){
                    sb.append(1).append("\n");
                    flag = true;
                    break;
                }else if(now.compareTo(arr.get(mid))==-1){
                    right = mid-1;
                }else if(now.compareTo(arr.get(mid))==1){
                    left = mid+1;
                }
            }
            if(!flag) sb.append(0).append("\n");
        }

        System.out.println(sb.toString());
    }
}
