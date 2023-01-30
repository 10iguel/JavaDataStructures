package edu.ensign.cs235.singlelinkedlist;


class NodeList{
    int data;
    NodeList next;
    public NodeList(int data, NodeList next){
        this.data = data;
        this.next = next;
    }
}



public class SinglyLinkedList {
    NodeList head;

    public boolean search(int value) {
        NodeList currentNode = head;
        while (currentNode != null){
            if (currentNode.data == value){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public int get_count() {
        return get_size();
    }

    public int get_size() {
        NodeList currentNode = head;
        int size = 0;
        while (currentNode != null){
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    public void insert_head(int i) {
        head = new NodeList(i, head);
    }

    public void insert(int i) {
        if (head == null){
            insert_head(i);
        }else {
            NodeList currentNode = head;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = new NodeList(i, null);
        }

    }

    public void insert_nth(int value, int index) {
        if (index == 0){
            insert_head(value);
        }else {
            NodeList currentNode = head;
            for (int i =0; i< index -1; i++){
                currentNode = currentNode.next;
            }
            currentNode.next = new NodeList(value, currentNode.next);
        }

    }

    public boolean is_empty() {
        return head == null;
    }

    public int get_nth(int n) {
        NodeList currentNode = head;
        for (int i =0; i < n; i++ ){
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public int delete_head() {
        int data = head.data;
        head = head.next;
        return data;
    }

    public int delete_nth(int n) {
        if (n == 0){
            return delete_head();
        }else {
            NodeList currentNode = head;
            for (int i =0; i < n -1; i++ ){
                currentNode = currentNode.next;
            }
            int value = currentNode.next.data;
            currentNode.next = currentNode.next.next;
            return value;
        }
    }

    public int delete() {
        if (head.next == null){
            delete_head();
        }
        NodeList currentNode = head;
        while (currentNode.next.next != null){
            currentNode = currentNode.next;
        }
        int value = currentNode.next.data;
        currentNode.next = null;
        return value;
    }

    public void clear() {
        head = null;
    }

    public String toString(){
        if (is_empty()){
            return "";
        }
        String val = "";
        NodeList current = head;
        while (current.next != null){
            val = val + current.data + " -> ";
            current = current.next;
        }
        val = val + current.data;
        return val;
    }

}
