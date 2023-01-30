/*
    Name:           Daniel Oliveira
    Student ID:     0x2EB8D7
    Date:           Mon Jan 17 03:48:38 PM MST 2022
    Class:          CS235 Data Structures and Algorithms
    Instructor:     Daniel Oliveira

    Description:    SingleLinkedList driver


    I pledge that the work done here was my own and that I have learned how to write this program, such that I could
    throw it out and restart and finish it in a timely manner. I am not turning in any work that I cannot understand,
    describe, or recreate. I further acknowledge that I contributed substantially to all code handed in and vouch for
    its authenticity. (Daniel Oliveira)

*/

    /*
    // Algorithm
    add_first(e):
        newest = Node(e);       // create a new node instance storing the reference to element 'e'.
        newest.next = head;     // set new node's next to reference the old head node
        head = newest;          // set head to reference the next node
        size = (size + 1);      // increment the node counter


    // Algorithm
    add_last(e):
        newest = Node(e);       // create a new node instance storing the reference to element 'e'.
        newest.next = null;     // set new node's next to reference the null node
        tail.next = newest      // make old tail node point to the new node
        tail = newest           // set tail to reference the new node
        size = (size + 1);      // increment the node counter

    // Algorithm
    remove_first():
        if head == null then;   //
            the list is empty;  //
        head = head.next;       // make head point to the next node (or null)
        size = (size - 1);      // decrement the node counter

     */


package edu.ensign.cs235.singlelinkedlist;


public class SinglyLinkedList_driver
{
    public static void main(String[] args) {
        SinglyLinkedList linked_list = new SinglyLinkedList();
        assert linked_list.get_size() == 0 && linked_list.get_count() == 0;
        assert linked_list.is_empty();

        /// Checking if the insert function works
        linked_list.insert_head(6);
        linked_list.insert_head(8);
        linked_list.insert_head(11);
        linked_list.insert(4);
        linked_list.insert_nth(1, 4);

        /// Use toString() to show all the elements.
        System.out.println(linked_list);
        System.out.println("size: " + linked_list.get_size());
        System.out.println("count: " + linked_list.get_count());
        System.out.println("");


        /// Testing searches
        assert linked_list.search(11) &&
               linked_list.search(6)  &&
               linked_list.search(1)  &&
               !linked_list.search(1000);

        /// Testing gets
        assert linked_list.get_nth(0) == 11 &&
               linked_list.get_nth(2) == 6  &&
               linked_list.get_nth(4) == 1;

        /// Testing deletion
        linked_list.delete_head();
        linked_list.delete_nth(1);
        linked_list.delete();
        /// Use toString() to show all the elements.
        System.out.println(linked_list);
        System.out.println("");
        System.out.println("size: " + linked_list.get_size());
        System.out.println("count: " + linked_list.get_count());

        ///
        linked_list.clear();
        assert linked_list.is_empty();
    }

}

