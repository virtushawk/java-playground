package com.virtushawk.app.jni;

public class JNIApplication {

    static {
        System.loadLibrary("sum");
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        System.out.println(sum(x, y));
    }

    static native int sum(int x, int y);
}
