package com.core1;

public class BaseClass {
    public String publicVar = "Public Variable";
    protected String protectedVar = "Protected Variable";
    String defaultVar = "Default Variable";
    private String privateVar = "Private Variable";

    public void display() {
        System.out.println("Inside BaseClass:");
        System.out.println("Public: " + publicVar);
        System.out.println("Protected: " + protectedVar);
        System.out.println("Default: " + defaultVar);
        System.out.println("Private: " + privateVar);
    }
}
