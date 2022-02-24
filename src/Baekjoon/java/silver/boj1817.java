package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//짐 챙기는 숌
public class boj1817 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseUnsignedInt(st.nextToken());
        int answer = 0;

        if(N>0) {
            st = new StringTokenizer(br.readLine());
            int box = 0;
            for (int i = 0; i < N; i++) {
                int book = Integer.parseInt(st.nextToken());
                if (box + book < M) {
                    box += book;
                } else if (box + book == M) {
                    answer += 1;
                    box = 0;
                } else {
                    answer += 1;
                    box = book;
                }
            }
            if (box != 0) answer += 1;
        }
        System.out.println(answer);

    }

}
