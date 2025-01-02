package com.core;

import com.core1.BaseClass;

public class OtherClass {
    public void testAccess() {
        BaseClass base = new BaseClass();

        System.out.println("Accessing from OtherClass (Different Package):");
        System.out.println("Public: " + base.publicVar);       // Accessible
        // System.out.println("Protected: " + base.protectedVar); // Not Accessible
        // System.out.println("Default: " + base.defaultVar);     // Not Accessible
        // System.out.println("Private: " + base.privateVar);     // Not Accessible
    }
}
