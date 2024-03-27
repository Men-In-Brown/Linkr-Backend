package com.nighthawk.hacks;

public class StackHeapTestChar {
    public char ch = 'A'; // Primitive data type on the heap
    
    public static void changeChar(char chValue, char chRef, StackHeapTestChar charRef){
        System.out.println("--------------------");
        System.out.println("Before the testing:");
        System.out.println("--------------------");
        System.out.println("\n" + "\t" + chValue + "\n" + "\t" + chRef + "\n" + "\t" + charRef.ch);

        chValue = 'B';
        chRef = 'C';
        charRef.ch = 'D';

        System.out.println("--------------------");
        System.out.println("After the testing:");
        System.out.println("--------------------");
        System.out.println("\n" + "\t" + chValue + "\n" + "\t" + chRef + "\n" + "\t" + charRef.ch);
    }

    public static void main(String[] args){
        char ch = 'A'; // Primitive data type on the stack
        StackHeapTestChar charRef = new StackHeapTestChar();
        
        System.out.println("Before the testing Main method");
        System.out.println("--------------------");
        System.out.println("\t" + ch + " " + System.identityHashCode(ch));
        System.out.println("\t" + charRef.ch + " " + System.identityHashCode(charRef.ch));
        System.out.println("\t" + charRef.ch + " " + System.identityHashCode(charRef));

        changeChar(ch, charRef.ch, charRef);

        System.out.println("--------------------");
        System.out.println("After the testing Main method");
        System.out.println("--------------------");
        System.out.println("\t" + ch + " " + System.identityHashCode(ch));
        System.out.println("\t" + charRef.ch + " " + System.identityHashCode(charRef.ch));
        System.out.println("\t" + charRef.ch + " " + System.identityHashCode(charRef));
    }
}