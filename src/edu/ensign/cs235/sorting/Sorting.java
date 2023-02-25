package edu.ensign.cs235.sorting;

import java.util.*;

public class Sorting {
    int[] randomNumbers;

    public Sorting(int k_num_of_randoms) {
        randomNumbers = new int[k_num_of_randoms];
    }

    public void generate_randoms() {
        int min = 1;
        int max = 99999;
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random() * (max - min + 1) + min);
        }
    }

    public void display_numbers() {
        for (int num : randomNumbers) {
            System.out.print(num + "; ");
        }
        System.out.println("\n");
    }

    public String get_size() {
        return Integer.toString(randomNumbers.length);
    }

    public void run_merge_sort() {
        long start = System.currentTimeMillis();
        System.out.println("** Merge-Sort:");
        merge(randomNumbers);
        display_numbers();
        long end = System.currentTimeMillis();
        elapsedTime(start, end);
    }

    private void merge(int[] numbers) {
        if (numbers == null) {
            return;
        }
        int size = numbers.length;
        if (size > 1) {
            int middle = size / 2;
            int[] left = Arrays.copyOfRange(numbers, 0, middle);
            int[] right = Arrays.copyOfRange(numbers, middle, size);
            merge(left);
            merge(right);
            merge_sort(numbers, left, right);
        }
    }

    private void merge_sort(int[] numbers, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                numbers[k] = left[i];
                i++;
            } else {
                numbers[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            numbers[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            numbers[k] = right[j];
            j++;
            k++;
        }
    }

    public void run_quick_sort() {
        long start = System.currentTimeMillis();
        System.out.println("** Quick-Sort:");
        quick(randomNumbers, 0, randomNumbers.length - 1);
        display_numbers();
        long end = System.currentTimeMillis();
        elapsedTime(start, end);
    }

    private void quick(int[] numbers, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(numbers, low, high);
            quick(numbers, low, pivotIndex - 1);
            quick(numbers, pivotIndex + 1, high);
        }
    }

    private int partition(int[] numbers, int low, int high) {
        int pivot = numbers[high];
        int i = low - 1;
        for (int j = 0; j < high; j++) {
            if (numbers[j] < pivot) {
                i++;
                swap(numbers, i, j);
            }
        }
        swap(numbers, i + 1, high);
        return i + 1;

    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[j];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public void run_insertion_sort() {
        long start = System.currentTimeMillis();
        System.out.println("** Insertion-Sort:");
        insertion(randomNumbers);
        display_numbers();
        long end = System.currentTimeMillis();
        elapsedTime(start, end);
    }

    private void insertion(int[] numbers) {
        if (numbers == null) {
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            int j = i - 1;
            while (j >= 0 && numbers[j] > numbers[i]) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = numbers[i];
        }
    }

    public void run_selection_sort() {
        long start = System.currentTimeMillis();
        System.out.println("** Selection-Sort:");
        selection(randomNumbers);
        display_numbers();
        long end = System.currentTimeMillis();
        elapsedTime(start, end);
    }

    private void selection(int[] numbers) {
        if (numbers == null) {
            return;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            int middle = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[middle]) {
                    middle = j;
                }
            }
            if (middle != i){
                swap(numbers, i, middle);
            }
        }
    }

    public void run_bucket_sort() {
        long start = System.currentTimeMillis();
        System.out.println("** Bucket-Sort:");
        bucket(randomNumbers);
        display_numbers();
        long end = System.currentTimeMillis();
        elapsedTime(start, end);
    }
    private void bucket(int[] numbers){
        int min = Arrays.stream(numbers).min().getAsInt();
        int max = Arrays.stream(numbers).max().getAsInt();
        int bucketCount = (max - min) / numbers.length +1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i=0; i< bucketCount;i++){
            buckets.add(new ArrayList<>());
        }
        for (int num : numbers){
            buckets.get((num - min) / numbers.length).add(num);
        }
        int i =0;
        for (List<Integer> bucket : buckets){
            bucket.sort(Integer::compareTo);
            for (int x : bucket){
                numbers[i++] = x;
            }
        }
    }

    public void run_radix_sort() {
        long start = System.currentTimeMillis();
        System.out.println("** Radix-Sort:");
        radix(randomNumbers, 5);
        display_numbers();
        long end = System.currentTimeMillis();
        elapsedTime(start, end);
    }
    private void radix(int[] numbers , int maxDigits){
        List<Queue<Integer>> digitQueues = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            digitQueues.add(new LinkedList<>());
        }
        for (int i = 0; i< maxDigits; i++){
            for (int j = 0; j < numbers.length; j++){
                int digit = getDigitAt(numbers[j],i);
                digitQueues.get(digit).add(numbers[j]);
            }
            int index = 0;
            for (Queue<Integer> queue : digitQueues){
                while (!queue.isEmpty()){
                    numbers[index++] = queue.remove();
                }
            }
        }
    }
    private int getDigitAt(int num, int pos){
        return (int) (num/ Math.pow(10, pos)) % 10;
    }

    public static void elapsedTime(long start, long end) {
        System.out.println("\nElapsed Time in ms: " + (end - start) + "\n");
    }
}
