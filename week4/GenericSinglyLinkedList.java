
public class GenericSinglyLinkedList<K,T> {
    private Node<K, T> header;

    public GenericSinglyLinkedList() {
        header = new Node<K, T>();
        header.key = null;
        header.data = null;
        header.next = null;
    }

    public boolean insert(K key, T value) {
        Node<K,T> newNode = new Node<K, T>();

        if(newNode == null) {
            return false;
        }
        else {
            newNode.next = header.next;
            header.next = newNode;
            newNode.data = value;
            newNode.key  = key;
            return true;
        }
    }

    public T fetch(K key) {
        Node<K, T> fetchedNode = header.next;

        while(fetchedNode != null && !(fetchedNode.key.equals(key)))
            fetchedNode = fetchedNode.next;

        if(fetchedNode != null)
            return fetchedNode.data;
        else
            return null;
    }

    public boolean delete(K key) {
        Node<K, T> q = header;
        Node<K, T> p = header.next;

        while(p != null && !(p.key.equals(key))) {
            q = p;
            p = p.next;
        }

        if(p != null) {
            q.next = p.next;
            return true;
        }
        else
            return false;
    }

    public boolean update(K key, T data) {
        if(delete(key) == false)
            return false;
        else if(insert(key, data) == false)
            return false;

        return true;
    }

    public void showAll() {
        Node<K, T> start = header.next;

        while(start != null) {
            System.out.println("Key: " + start.key.toString() + ". Value: " + start.data.toString());
            start = start.next;
        }
    }

    public class Node<K, T> {
        private K key;
        private T data;
        private Node<K, T> next;

        public Node() {}
    }
}


