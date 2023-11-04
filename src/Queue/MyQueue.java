package Queue;
import Queue.Node;

public class MyQueue<T> {

    private Queue.Node<T> firstNode;
    private Queue.Node<T> lastNode;

    public void add(T val) {
        if (firstNode == null) {
            firstNode = new Queue.Node<>(null, null, val);
        } else if (lastNode == null) {
            lastNode = new Queue.Node<>(firstNode, null, val);
            firstNode.setNextNode(lastNode);
        } else {
            Queue.Node<T> newLastNode = new Queue.Node<>(lastNode, null, val);
            lastNode.setNextNode(newLastNode);
            lastNode = newLastNode;
        }
    }

    public void clear(){
        Queue.MyQueue<T> queue = new Queue.MyQueue<T>();
    }

    public int size(){
        int size = 0;
        Queue.Node<T> currentNode = firstNode;

        while (currentNode != null) {
            size++;
            currentNode = currentNode.getNextNode();
        }

        return size;
    }

    public T peek(){
        return firstNode.getValue();
    }
    public T poll(){
        T first = firstNode.getValue();
        Queue.Node<T> currentNode = firstNode;
        currentNode.getNextNode().setPrevNode(null);
        firstNode = currentNode.getNextNode();
        currentNode.setNextNode(null);
        currentNode.setValue(null);
        return first;
    }


    public static void main(String[] args) {
        Queue.MyQueue<String> queue = new Queue.MyQueue<>();

        queue.add("asd1");
        queue.add("asd2");
        queue.add("asd3");
        queue.add("asd4");

        System.out.println("size: " + queue.size());

        System.out.println("queue.peek = " + queue.peek());
        System.out.println("queue.poll = " + queue.poll());

        System.out.println("size: " + queue.size());

    }
}
