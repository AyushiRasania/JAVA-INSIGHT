package com.core;

import com.core1.SamePackageClass;

//  Demonstrate the use of different access modifiers within the same package and
//  across different packages.
public class P26_MultipleAccessModifiersExample {
    public static void main(String[] args) {
        // Testing within the same package
        SamePackageClass samePackage = new SamePackageClass();
        samePackage.testAccess();

        System.out.println();

        // Testing with inheritance across packages
        DerivedClass derivedClass = new DerivedClass();
        derivedClass.testAccess();

        System.out.println();

        // Testing without inheritance across packages
        OtherClass otherClass = new OtherClass();
        otherClass.testAccess();
    }
}
