package edu.ensign.cs235.StackOnLinkedList;

class NodeList {
    int value;
    NodeList next;

    public NodeList(int value, NodeList next) {
        this.value = value;
        this.next = next;
    }
}

public class StackOnLinkedList {
    public NodeList head;

    public void push(int value) {
        if (head == null) {
            head = new NodeList(value, null);
        } else {
            head = new NodeList(value, head);
        }
    }

    public int get_size() {
        NodeList current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public int pop() {
        int value = head.value;
        head = head.next;
        return value;
    }

    public int peek() {
        return head.value;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        String text = "";
        NodeList current = head;
        while (current.next != null) {
            text = text + current.value + "->";
            current = current.next;
        }
        text = text + current.value;
        return text;
    }
}
