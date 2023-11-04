package Stack;

public class MyStack<T> {

        private Stack.Node<T> firstNode;
        private Stack.Node<T> lastNode;

        public void add(T val) {
        if (firstNode == null) {
            firstNode = new Stack.Node<>(null, null, val);
        } else if (lastNode == null) {
            lastNode = new Stack.Node<>(firstNode, null, val);
            firstNode.setNextNode(lastNode);
        } else {
            Stack.Node<T> newLastNode = new Stack.Node<>(lastNode, null, val);
            lastNode.setNextNode(newLastNode);
            lastNode = newLastNode;
        }
    }
    public void remove(int index){
        Stack.Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        Stack.Node<T> nextnode = firstNode;
        for (int i = 0; i < index+1; i++) {
            nextnode = nextnode.getNextNode();
        }
        Stack.Node<T> prevnode = firstNode;
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
        Stack.MyStack<T> Stack = new Stack.MyStack<T>();
    }

        public int size(){
        int size = 0;
        Stack.Node<T> currentNode = firstNode;

        while (currentNode != null) {
            size++;
            currentNode = currentNode.getNextNode();
        }

        return size;
    }

        public T peek(){
        return lastNode.getValue();
    }
        public T pop(){
        T first = lastNode.getValue();
        Stack.Node<T> currentNode = lastNode;
        currentNode.getPrevNode().setNextNode(null);
        lastNode = currentNode.getNextNode();
        currentNode.setPrevNode(null);
        currentNode.setValue(null);
        return first;
    }


        public static void main(String[] args) {
        Stack.MyStack<String> Stack = new Stack.MyStack<>();

        Stack.add("asd1");
        Stack.add("asd2");
        Stack.add("asd3");
        Stack.add("asd4");

        System.out.println("size: " + Stack.size());

        System.out.println("Stack.peek = " + Stack.peek());
        System.out.println("Stack.poll = " + Stack.pop());

        System.out.println("size: " + Stack.size());

    }
    }
