package com.virtushawk.app.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadMergeSort {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = List.of(15, 19, 6, 5, 18, 14, 2, 7, 8, 17);

        Thread thread = new Thread(new RunnableClass(list));
        thread.start();

        thread.join();
    }


    private static class RunnableClass implements Runnable {

        private final List<Integer> list = new ArrayList<>();

        public RunnableClass(List<Integer> list) {
            this.list.addAll(list);
        }

        @Override
        public void run() {
            int[] array = list.stream().mapToInt(Integer::intValue).toArray();
            sort(array);
            System.out.println(Arrays.toString(array));
        }

        private static void sort(int[] a) {
            int n = a.length;

            if (n < 2) {
                return;
            }

            int mid = n / 2;

            int[] l = new int[mid];
            int[] r = new int[n - mid];

            System.arraycopy(a, 0, l, 0, mid);
            System.arraycopy(a, mid, r, 0, n - mid);

            sort(l);
            sort(r);

            merge(a, l, r);
        }

        private static void merge(int[] a, int[] l, int[] r) {
            int left = l.length;
            int right = r.length;

            int i = 0, j = 0, k = 0;
            while (i < left && j < right) {
                if (l[i] < r[j]) {
                    a[k++] = l[i++];
                } else {
                    a[k++] = r[j++];
                }
            }

            while (i < left) {
                a[k++] = l[i++];
            }

            while (j < right) {
                a[k++] = r[j++];
            }
        }
    }
}
