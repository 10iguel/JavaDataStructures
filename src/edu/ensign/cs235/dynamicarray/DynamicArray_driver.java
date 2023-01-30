/*
    Name:           Daniel Oliveira
    Student ID:     0x2EB8D7
    Date:           Jan 11, 2022 19:01:22 MST 2022
    Class:          CS235 Data Structures and Algorithms
    Instructor:     Daniel Oliveira

    Description:    DynamicArray_driver


    I pledge that the work done here was my own and that I have learned how to write this program, such that I could
    throw it out and restart and finish it in a timely manner. I am not turning in any work that I cannot understand,
    describe, or recreate. I further acknowledge that I contributed substantially to all code handed in and vouch for
    its authenticity. (Daniel Oliveira)

*/

package edu.ensign.cs235.dynamicarray;

import java.util.HashMap;
import java.time.*;
import java.util.Map;
import java.util.Random;


public class DynamicArray_driver
{
    private static final int k_initial_number = 1;
    private static final int k_default_array_size = 100;
    private static long m_start_time = 0;
    private static long m_stop_time = 0;

    protected static void display_elapsed_time_in_ms(long start_time, long stop_time)
    {
        System.out.println("\n Elapsed Time in ms: " + (stop_time - start_time) + " \n");
    }

    /// Same generate_sequentials from ArrayIteration
    protected static DynamicArray<Integer> generate_sequentials(DynamicArray<Integer> numbers_list)
    {
        int sequential_number = k_initial_number;
        m_start_time = System.currentTimeMillis();

        for (int idx = 0; idx < numbers_list.get_capacity(); idx++) {
            numbers_list.add(sequential_number);
            sequential_number++;
        }

        m_stop_time = System.currentTimeMillis();

        /// Elapsed Time.
        display_elapsed_time_in_ms(m_start_time, m_stop_time);

        return numbers_list;
    }

    /// generate a random number in a given range [min, max)
    /// when Math.random returns 0.0, which is the lowest possible output:
    /// 0.0 * (max - min) + min => min
    /// So, the lowest number we can get is min.
    ///
    ///  1.0 is the exclusive upper bound of Math.random, this is what we get
    /// 1.0 * (max - min) + min => max - min + min => max
    /// Therefore, the exclusive upper bound of our method's return is max.
    private static int impl_generate_random_v1(int min_value, int max_value)
    {
        return (int) ((Math.random() * (max_value - min_value)) + min_value);
    }

    /// Same generate_sequentials from ArrayIteration
    protected static DynamicArray<Integer> generate_randoms(DynamicArray<Integer> numbers_list, int randoms)
    {
        final int k_initial_value = 1;
        final int k_final_value   = (numbers_list.get_capacity() * 500);

        int num_of_randoms = (randoms != 0) ? randoms : numbers_list.get_capacity();

        m_start_time = System.currentTimeMillis();

        for (int idx = 0; idx < num_of_randoms; idx++) {
            numbers_list.add(impl_generate_random_v1(k_initial_value, k_final_value));
        }

        m_stop_time = System.currentTimeMillis();

        /// Elapsed Time.
        display_elapsed_time_in_ms(m_start_time, m_stop_time);

        return numbers_list;
    }


    public static void main(String[] args) {
        DynamicArray<Integer> numbers_list = new DynamicArray<>();
        numbers_list = generate_randoms(numbers_list, 100);
        ////numbers_list = generate_sequentials(numbers_list);

        /*
        numbers_list.add(-5);
        numbers_list.add(10);
        numbers_list.add(8);
        numbers_list.add(5);
        numbers_list.add(3);
        numbers_list.add(1);
        numbers_list.add(9);
        numbers_list.add(7);
        numbers_list.add(6);
        numbers_list.add(20);
        numbers_list.add(4);
        numbers_list.add(2);
        */

        /// Using Iterator
        for (var number : numbers_list.myArray) {
            System.out.print(number + ", ");
        }

        ////numbers_list.stream().forEach(System.out::println);
        ////System.out.println(numbers_list);
        System.out.println("\nDynamicArray Size: " + numbers_list.get_size());
        System.out.println("DynamicArray Capacity: " + numbers_list.get_capacity());

        System.out.println("\nRemoving values from the DynamicArray: ");
        for (var idx = 0; idx < 50; idx++) {
            var value_removed = numbers_list.remove(idx);
            //System.out.println("Element: " + value_removed + " removed");
        }

        System.out.println("\nDynamicArray Size: " + numbers_list.get_size());
        System.out.println("DynamicArray Capacity: " + numbers_list.get_capacity());

        for (var number : numbers_list.myArray) {
            System.out.print(number + "; ");
        }
        System.out.println("\n");
    }

    /*
    public Map<Integer, Integer> find_smallest_and_largest_elements(DynamicArray<Integer> number_list)
    {
        Map<Integer, Integer> smallest_largest_pair = new HashMap<>();
    }
     */
}
