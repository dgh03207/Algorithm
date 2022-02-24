package Baekjoon.java.silver;

import java.util.stream.IntStream;

//종이 접기
public class boj1802 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        IntStream stream= IntStream.of(arr);

        stream.forEach(System.out::println);

        stream.forEach(System.out::println);
    }
}
