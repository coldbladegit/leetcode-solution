package com.cold.blade;

import com.cold.blade.lintcode.CalculateAPlusB;
import com.cold.blade.lintcode.MergeSortedArray;
import com.cold.blade.lintcode.NumFactorial;

public class Main {

    public static void main(String[] args) {
        System.out.println(NumFactorial.solution(25, NumFactorial.NUM_ZERO_COUNT));
        System.out.println(CalculateAPlusB.solution(25, -25));
        int[] a = {1, 3, 4, 5, 6, 7, 8};
        int[] b = {1, 3, 4, 5, 6, 7, 8};
        int[] c = MergeSortedArray.solution(a, b);
        for (int elem : c) {
            System.out.print(elem);
            System.out.print(',');
        }
    }
}
