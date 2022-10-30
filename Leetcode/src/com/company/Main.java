package com.company;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

    int[] height = IntStream.of(1,8,6,2,5,4,8,3,7).toArray();
	// write your code here
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {

        System.out.println(height[1]);

        return 1;
    }

}
