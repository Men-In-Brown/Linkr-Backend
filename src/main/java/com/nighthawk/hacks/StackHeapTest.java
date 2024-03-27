package com.nighthawk.hacks;

public class StackHeapTest {
    public int n = 5; // primitive data type on the heap
    
    public static void changeInt(int nValue, int nRefN, StackHeapTest nRef){
        System.out.println("--------------------");
        System.out.println("Before the testing:");
        System.out.println("--------------------");
        System.out.println("\n" + "\t" + nValue + "\n" + "\t" + nRefN + "\n" + "\t" + nRef.n);

        nValue += 10;
        nRefN += 10;
        nRef.n += 10;

        System.out.println("--------------------");
        System.out.println("After the testing:");
        System.out.println("--------------------");
        System.out.println("\n" + "\t" + nValue + "\n" + "\t" + nRefN + "\n" + "\t" + nRef.n);
    }

    public static void main(String[] args){
        int n = 5; // primitive data type on the stack
        StackHeapTest nRef = new StackHeapTest();
        
        System.out.println("Before the testing Main method");
        System.out.println("--------------------");
        System.out.println("\t" + n + " " + System.identityHashCode(n));
        System.out.println("\t" + nRef.n + " " + System.identityHashCode(nRef.n));
        System.out.println("\t" + nRef.n + " " + System.identityHashCode(nRef));

        changeInt(n, nRef.n, nRef); // stack by value, heap by value, heap by reference

        System.out.println("--------------------");
        System.out.println("After the testing Main method");
        System.out.println("--------------------");
        System.out.println("\t" + n + " " + System.identityHashCode(n));
        System.out.println("\t" + nRef.n + " " + System.identityHashCode(nRef.n));
        System.out.println("\t" + nRef.n + " " +  System.identityHashCode(nRef));
    }
}
