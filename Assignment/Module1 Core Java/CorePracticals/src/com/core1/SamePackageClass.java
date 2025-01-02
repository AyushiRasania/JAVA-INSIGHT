package com.core1;

public class SamePackageClass {
    public void testAccess() {
        BaseClass base = new BaseClass();

        System.out.println("Accessing from SamePackageClass:");
        System.out.println("Public: " + base.publicVar);       // Accessible
        System.out.println("Protected: " + base.protectedVar); // Accessible
        System.out.println("Default: " + base.defaultVar);     // Accessible
        // System.out.println("Private: " + base.privateVar);  // Not Accessible
    }
}
