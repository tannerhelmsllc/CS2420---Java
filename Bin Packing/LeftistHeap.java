public class LeftistHeap<E extends Comparable<? super E>> {
    public Node<E> root;
    LeftistHeap(){
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void makeEmpty() {
        root = null;
    }

    public void Insert(E x) {
        root = merge(root, new Node<>(x));
    }

    public void merge (LeftistHeap<E> heap) {
        if (this == heap) {return;};
        root = merge(root, heap.root);
    }

    private Node<E> merge(Node<E> n1, Node<E> n2) {
        if (n1 == null) {return n2;};
        if (n2 == null) {return n1;};
        if (n1.element.compareTo(n2.element) < 0) {
            if (n1.left == null) {
                n1.left = n2;
            } else {
                n1.right = merge(n1.right, n2);
                if (n1.left.npl < n1.right.npl) {
                    // Swap Children
                    Node<E> tmp = n1.left;
                    n1.left = n1.right;
                    n1.right = tmp;
                }
                n1.npl = n1.right.npl + 1;
            }
            return  n1;
        } else {
            return merge(n2,n1);
        }
    }
    private E deleteMin() {
        if (isEmpty()){return null;};
        E ele = root.element;
        root = merge(root.left, root.right);
        return ele;
    }
    public static class Node<E> {
        public E element;
        Node<E> left;
        Node<E> right;
        int npl;

        Node(E theElement) {
            this(theElement, null, null);
        }
        Node(E theElement, Node<E> lt, Node<E> rt) {
            element = theElement;
            left = lt;
            right = rt;
            npl = 0;
        }
    }
    public static void main(String[] args) {
        LeftistHeap<Integer> tree = new LeftistHeap<>();
        tree.Insert(4);
        tree.Insert(7);
        tree.Insert(2);
        tree.Insert(9);
        tree.Insert(12);
        tree.Insert(-1);
    }
}

