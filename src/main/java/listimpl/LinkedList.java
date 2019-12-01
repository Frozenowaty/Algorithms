package listimpl;

public class LinkedList<T> implements IList<T> {
    private Node<T> firstNode;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T value) {
        if (isEmpty()) {
            firstNode = new Node<>(value);
            size++;
            return;
        }
        Node<T> tmpNode = firstNode;
        while(tmpNode.getNextNode() != null)
            tmpNode = tmpNode.getNextNode();
        tmpNode.setNextNode(new Node<>(value));
        size++;
    }


    @Override
    public void add(T value, int index) {
        checkInsertBounds(index);
        if (index==size) {
            add(value);
            return;
        }
        Node<T> tmpNode = firstNode;
        if (index==0) {
            firstNode = new Node<>(value);
            firstNode.setNextNode(tmpNode);
            size++;
            return;
        }
        for (int i = 0; i < index-1; i++){
            tmpNode = tmpNode.getNextNode();
        }
        Node<T> newNode = new Node<>(value,tmpNode.getNextNode());
        tmpNode.setNextNode(newNode);
        size++;

    }

    @Override
    public T get(int index) {
        checkGetBounds(index);
        Node<T> tmp = firstNode;
        for (int i = 0; i<index;i++)
            tmp = tmp.getNextNode();
        return tmp.getValue();
    }

    @Override
    public void set(T value, int index) {
        checkGetBounds(index);
        Node<T> tmp = firstNode;
        for (int i = 0; i<index;i++)
            tmp = tmp.getNextNode();
        tmp.setValue(value);


    }

    @Override
    public void remove(int index) {
        checkGetBounds(index);
        if (index == 0){
            firstNode = firstNode.getNextNode();
            size--;
            return;
        }
        Node<T> tmpNode = firstNode;
        for (int i = 0; i < index-1; i++)
            tmpNode = tmpNode.getNextNode();
        Node<T> nodeToDelete = tmpNode.getNextNode();
        tmpNode.setNextNode(nodeToDelete.getNextNode());
        size--;

    }

    @Override
    public void swap(int index1, int index2) {
        checkGetBounds(index1);
        checkGetBounds(index2);
        T tmp = get(index1);
        set(get(index2),index1);
        set(tmp,index2);
    }

    private void checkGetBounds(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }
    private void checkInsertBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();

        }
    }
}
