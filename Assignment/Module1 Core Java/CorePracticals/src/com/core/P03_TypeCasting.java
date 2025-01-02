package com.core;

// Demonstrate typecasting (explicit and implicit)
public class P03_TypeCasting {
    public static void main(String[] args) {

        int a = 10;
        int b = 5;
        double c = (double) a / (double) b;
        System.out.println(c);

        int i = (int) 3.14;//explicit
        System.out.println(i);

        int q = 12;
        double d = q;//implicit
        System.out.println(d);
    }
}
