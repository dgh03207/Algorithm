package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//배
import java.util.ArrayList;
import java.util.Collections;

public class boj1092 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cranes = new int[N];
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(boxes,Collections.reverseOrder());
        Arrays.sort(cranes);

        int answer = 0;
        if(cranes[N-1]<boxes.get(0)) {
            answer = -1;
        }
        else {
            while (!boxes.isEmpty()) {
                int j = 0;
                for (int i = N - 1; i >= 0;) {
                    if (j == boxes.size()) break;
                    else if (cranes[i] >= boxes.get(j)) {
                        boxes.remove(j);
                        i-=1;
                    } else j += 1;
                }
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
