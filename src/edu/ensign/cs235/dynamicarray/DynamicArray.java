package edu.ensign.cs235.dynamicarray;

import java.util.Arrays;

public class DynamicArray<T> {
    public int[] myArray;

    public int sizeOfArray;

    public int indexCount;


    public DynamicArray() {
        myArray = new int[20];
    }


    public DynamicArray(final int capacity) {
        myArray = new int[capacity];
    }


    public void add(final int element) {
        indexCount = myArray.length;
        if (sizeOfArray == indexCount) {
            System.out.println("Info: * Add() reached maximum size: "
                    + sizeOfArray + "   -   Max Capacity: " + indexCount);
            indexCount = indexCount * 2;
            myArray = Arrays.copyOf(myArray, indexCount);
            System.out.println("Info: * Add() reached maximum size: "
                    + sizeOfArray + "   -   Max Capacity: " + indexCount);
        }

        myArray[sizeOfArray] = element;

        sizeOfArray++;

        indexCount = myArray.length;
    }

    public int remove(final int idx) {
        if (myArray == null || idx < 0
                || idx >= myArray.length) {
            return 0;
        }
        if (myArray.length > 20 && sizeOfArray * 3 <= indexCount) {
            System.out.println("Info: * Remove() condition reached size: "
                    + sizeOfArray + "   -   Max Capacity: " + indexCount);
            indexCount = indexCount / 2;
            myArray = Arrays.copyOf(myArray, indexCount);
            System.out.println("Info: * Remove() condition reached size: "
                    + sizeOfArray + "   -   Max Capacity: " + indexCount);
        }

        int[] newArray = new int[myArray.length - 1];

        int removedItem = 0;

        for (int i = 0, k = 0; i < myArray.length; i++) {
            if (i != idx) {
                newArray[k] = myArray[i];
                k++;
            } else {
                removedItem = myArray[i];
            }
        }

        myArray = Arrays.copyOf(newArray, indexCount);

        sizeOfArray--;
        return removedItem;

    }


    public void put(final int idx, int element) {

    }


    public int get(final int idx) {
        return myArray[idx];
    }


    public int get_size() {
        return sizeOfArray;
    }

    public int get_capacity() {
        return myArray.length;
    }

    public boolean is_empty() {
        return myArray.length == 0;
    }

}
