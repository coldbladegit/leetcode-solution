package com.cold.blade.leetcode;

/**
 * @author cold_blade
 * @version 1.0
 * @description
 * @date 2018/9/20
 */
public final class MergeSortedArray {

    private MergeSortedArray() {
    }

    public static int[] solution(int[] a, int[] b) {
        int[] newArray = new int[a.length + b.length];
        if (a[a.length - 1] <= b[0]) {
            System.arraycopy(a, 0, newArray, 0, a.length);
            System.arraycopy(b, 0, newArray, a.length, b.length);
        } else if (a[0] >= b[b.length - 1]) {
            System.arraycopy(b, 0, newArray, 0, b.length);
            System.arraycopy(a, 0, newArray, b.length, a.length);
        } else {
            if (a.length > b.length) {
                mergeSortedArray(b, a, newArray);
            } else {
                mergeSortedArray(a, b, newArray);
            }
        }
        return newArray;
    }

    private static void mergeSortedArray(int[] smallArray, int[] bigArray, int[] newArray) {
        int bigArrayStartIndex = 0;
        int bigArrayPos;
        int newArrayPos = 0;
        int copyLen;
        int key;
        for (int i = 0; i < smallArray.length; ++i) {
            key = smallArray[i];
            if (key <= bigArray[bigArrayStartIndex]) {
                newArray[newArrayPos++] = key;
            } else if (key >= bigArray[bigArray.length - 1]) {
                copyLen = bigArray.length - bigArrayStartIndex;
                System.arraycopy(bigArray, bigArrayStartIndex, newArray, newArrayPos, copyLen);
                System.arraycopy(smallArray, i, newArray, newArrayPos + copyLen,
                    smallArray.length - i);
                // 表示copy工作结束
                newArrayPos = newArray.length;
                break;
            } else {
                bigArrayPos = getArrayFirstIndex(bigArray, bigArrayStartIndex, key);
                copyLen = bigArrayPos - bigArrayStartIndex;
                System.arraycopy(bigArray, bigArrayStartIndex, newArray, newArrayPos, copyLen);
                bigArrayStartIndex = bigArrayPos;
                newArrayPos += copyLen;
                newArray[newArrayPos++] = key;
            }
        }
        if (newArrayPos != newArray.length) {
            // 将big array中剩余的元素copy到 new array中
            System.arraycopy(bigArray, bigArrayStartIndex, newArray, newArrayPos,
                bigArray.length - bigArrayStartIndex);
        }
    }

    /**
     * 获取有序数组中第一个大于或等于 key值的索引
     */
    private static int getArrayFirstIndex(int[] array, int begin, int key) {
        int end = array.length - 1;
        int mid;
        while (begin < end) {
            mid = (begin + end) >> 1;
            if (array[mid] >= key) {
                if (mid == begin || array[mid - 1] < key) {
                    return mid;
                }
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
