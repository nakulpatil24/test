package com.test.recursion;

public class FindOccurrence {

    static int timeComplexityCounter = 0;

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Occurances are : " + searchNumOccurrence(array, 1, 0, array.length - 1));
    }

    /*
     * V is sorted V.size() = N The function is initially called as searchNumOccurrence(V, k, 0, N-1)
     */
    // complexity in O(n) and not O(log n)
    public static int searchNumOccurrence(int[] V, int k, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = (start + end) / 2;
        if (V[mid] < k) {
            return searchNumOccurrence(V, k, mid + 1, end);
        }
        if (V[mid] > k) {
            return searchNumOccurrence(V, k, start, mid - 1);
        }
        System.out.println(++timeComplexityCounter);
        return searchNumOccurrence(V, k, start, mid - 1) + 1 + searchNumOccurrence(V, k, mid + 1, end);
    }
}
