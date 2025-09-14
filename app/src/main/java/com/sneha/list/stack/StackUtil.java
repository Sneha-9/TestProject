package com.sneha.list.stack;

import java.util.Arrays;

public class StackUtil {


    public static Integer[] previousSmallest(Integer[] data) {
        Integer[] res = new Integer[data.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(res, -1);

        for (int i = data.length - 1; i >= 0; i--) {

            while (st.size() != 0 && data[st.peek()] > data[i]) {
                res[st.pop()] = data[i];
            }

            st.push(i);

        }

        return res;


    }

    public static Integer[] previousLargest(Integer[] data) {
        Integer[] res = new Integer[data.length];
        Stack<Integer> st = new Stack();
        Arrays.fill(res, -1);

        for (int i = data.length - 1; i >= 0; i--) {

            while (st.size() != 0 && data[st.peek()] < data[i]) {
                res[st.pop()] = data[i];
            }

            st.push(i);

        }

        return res;

    }

    public static Integer[] nextSmallest(Integer[] data) {
        Integer[] res = new Integer[data.length];
        Stack<Integer> st = new Stack();
        Arrays.fill(res, -1);
        for (int i = 0; i < data.length; i++) {

            while (st.size() != 0 && data[st.peek()] > data[i]) {
                res[st.pop()] = data[i];
            }

            st.push(i);

        }

        return res;

    }

    public static Integer[] nextLargest(Integer[] data) {
        Integer[] res = new Integer[data.length];
        Stack<Integer> st = new Stack();

        Arrays.fill(res, -1);

        for (int i = 0; i < data.length; i++) {

            while (st.size() != 0 && data[st.peek()] < data[i]) {
                res[st.pop()] = data[i];
            }

            st.push(i);

        }

        return res;

    }
}
