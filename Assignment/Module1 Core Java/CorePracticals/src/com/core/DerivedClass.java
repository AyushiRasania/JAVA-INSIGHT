package com.core;

import com.core1.BaseClass;

public class DerivedClass extends BaseClass {
    public void testAccess() {
        System.out.println("Accessing from DerivedClass (Different Package):");
        System.out.println("Public: " + publicVar);       // Accessible
        System.out.println("Protected: " + protectedVar); // Accessible
        // System.out.println("Default: " + defaultVar);  // Not Accessible
        // System.out.println("Private: " + privateVar);  // Not Accessible
    }
}
