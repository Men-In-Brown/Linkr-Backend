package com.nighthawk.hacks;

public class StackHeapTestDouble {
    public double d = 5.0; // Primitive data type on the heap
    
    public static void changeDouble(double dValue, double dRef, StackHeapTestDouble doubleRef){
        System.out.println("--------------------");
        System.out.println("Before the testing:");
        System.out.println("--------------------");
        System.out.println("\n" + "\t" + dValue + "\n" + "\t" + dRef + "\n" + "\t" + doubleRef.d);

        dValue += 10.0;
        dRef += 10.0;
        doubleRef.d += 10.0;

        System.out.println("--------------------");
        System.out.println("After the testing:");
        System.out.println("--------------------");
        System.out.println("\n" + "\t" + dValue + "\n" + "\t" + dRef + "\n" + "\t" + doubleRef.d);
    }

    public static void main(String[] args){
        double d = 5.0; // Primitive data type on the stack
        StackHeapTestDouble doubleRef = new StackHeapTestDouble();
        
        System.out.println("Before the testing Main method");
        System.out.println("--------------------");
        System.out.println("\t" + d + " " + System.identityHashCode(d));
        System.out.println("\t" + doubleRef.d + " " + System.identityHashCode(doubleRef.d));
        System.out.println("\t" + doubleRef.d + " " + System.identityHashCode(doubleRef));

        changeDouble(d, doubleRef.d, doubleRef);

        System.out.println("--------------------");
        System.out.println("After the testing Main method");
        System.out.println("--------------------");
        System.out.println("\t" + d + " " + System.identityHashCode(d));
        System.out.println("\t" + doubleRef.d + " " + System.identityHashCode(doubleRef.d));
        System.out.println("\t" + doubleRef.d + " " + System.identityHashCode(doubleRef));
    }
}