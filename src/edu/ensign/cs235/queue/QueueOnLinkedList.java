package edu.ensign.cs235.queue;

class NodeList{
    int value;
    NodeList next;
    public NodeList(int value, NodeList next){
        this.value = value;
        this.next = next;
    }
}

public class QueueOnLinkedList {

    private NodeList head;

    public boolean is_empty() {
        return head == null;
    }

    public void enqueue(int value) {
        if (head == null){
            head = new NodeList(value, head);
        }else {
            NodeList current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = new NodeList(value, null);
        }
    }

    public int get_size() {
        if (head == null){
            return 0;
        }
        NodeList current = head;
        int count = 0;
        while (current.next !=null){
            count++;
            current = current.next;
        }
        return count+1;
    }

    public int peek_front() {
        return head.value;
    }

    public int dequeue() {
        int value = head.value;
        head = head.next;
        return value;
    }

    public int peek_rear() {
        NodeList current = head;
        while (current.next != null){
            current = current.next;
        }
        return  current.value;
    }

    public void clear() {
        head = null;
    }

    @Override
    public String toString() {
        if (is_empty()){
            return "[]";
        }else {
            String text = "[";
            NodeList current = head;
            while (current.next != null){
                text = text + current.value + ", ";
                current = current.next;
            }
            text = text + current.value + "]";
            return text;
        }
    }
}
