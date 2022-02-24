package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//귀찮음
public class boj16208 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] stick = new long[N];
        int length = 0;

        for (int i = 0; i < N; i++) {
            stick[i] = Integer.parseInt(st.nextToken());
            length += stick[i];
        }
        long answer = 0;

        for (int i = 0; i <N; i++) {
            length -= stick[i];
            if(length!=0){
                answer += stick[i]*length;
            }

        }

        System.out.println(answer);
    }
}
