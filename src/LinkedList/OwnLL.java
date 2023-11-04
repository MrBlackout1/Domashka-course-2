package LinkedList;

import java.util.Arrays;

public class OwnLL<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;

    public void add(T val) {
        if (firstNode == null) {
            firstNode = new Node<>(null, null, val);
        } else if (lastNode == null) {
            lastNode = new Node<>(firstNode, null, val);
            firstNode.setNextNode(lastNode);
        } else {
            Node<T> newLastNode = new Node<>(lastNode, null, val);
            lastNode.setNextNode(newLastNode);
            lastNode = newLastNode;
        }
    }

    public void remove(int index){
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        Node<T> nextnode = firstNode;
        for (int i = 0; i < index+1; i++) {
            nextnode = nextnode.getNextNode();
        }
        Node<T> prevnode = firstNode;
        for (int i = 0; i < index-1; i++) {
            prevnode = prevnode.getNextNode();
        }
        currentNode.setValue(null);
        currentNode.setNextNode(null);
        currentNode.setPrevNode(null);

        nextnode.setPrevNode(prevnode);
        prevnode.setNextNode(nextnode);
    }

    public void clear(){
    OwnLL<T> ll = new OwnLL<T>();
    }

    public int size(){
        int size = 0;
        Node<T> currentNode = firstNode;

        while (currentNode != null) {
            size++;
            currentNode = currentNode.getNextNode();
        }

        return size;
    }

    public T get(int index) {
        if(index>=0 && index < size()) {
            Node<T> currentNode = firstNode;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getValue();
        }
        else{
            return (T) "Error: index out of boundary";
        }
    }

    public static void main(String[] args) {
        OwnLL<String> ll = new OwnLL<>();

        ll.add("asd1");
        ll.add("asd2");
        ll.add("asd3");
        ll.add("asd4");

        System.out.println("ll.get(2) = " + ll.get(2));
        ll.remove(1);
        System.out.println("ll.get(1) = " + ll.get(1));

        System.out.println("ll.get(10) = " + ll.get(10));

        System.out.println("size: " + ll.size());

    }
}
