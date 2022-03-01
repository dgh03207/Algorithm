package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

//종이 접기
public class boj1802 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String answer="YES";
            String[] papers = br.readLine().split("");
            int size = papers.length;
            if(size>1) {
                int middle = size/2;
                chain:
                while(middle>=1){
                    for (int j = 0; j < middle; j++) {
                        if (papers[j].equals(papers[size-1-j])){
                            answer = "NO";
                            break chain;
                        }
                    }
                    size=middle;
                    middle = middle/2;
                }
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
