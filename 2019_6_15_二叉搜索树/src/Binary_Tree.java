/**
 * @Author: yd
 * @Date: 2019/6/15 13:52
 * @Version 1.0
 */
public class Binary_Tree<E extends Comparable<E> > implements BST<E> {
    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node root, E e) {
        if (root == null) {
            Node newNode = new Node(e);
            size++;
            return newNode;
        }
        if (e.compareTo(root.e) < 0) {
            root.left = add(root.left, e);
        } else if (e.compareTo(root.e) > 0) {
            root.right = add(root.right, e);
        }
        return root;


    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if ((root.e.compareTo(e)) == 0) {
            return true;
        } else if ((e.compareTo(root.e)) < 0) {
            return contains(root.left, e);
        } else {
            return contains(root.right, e);
        }
    }

    @Override
    public E findMax() {
        return findMax(root).e;
    }

    private Node findMax(Node root) {
        if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    @Override
    public E findMin() {
        return findMin(root).e;
    }

    private Node findMin(Node root) {
        if (root.left == null) {
            return root;
        }
        return findMax(root.left);

    }

    @Override
    public void removeMax() {
        isEmpty();
        root= removeMax(root);
    }

    private Node removeMax(Node root) {
        if (root.right == null) {
            Node temp = root.left;
            root.left=null;
            size--;
            return temp;
        }
        root.right = removeMax(root.right);
        return root;

    }

    @Override
    public void removeMin() {
        isEmpty();
        root=removeMin(root);
    }

    private Node removeMin(Node root) {
        if (root.left == null) {
            Node temp = root.right;
            root.right=null;
            size--;
            return temp;
        }
        root.left = removeMin(root.left);
        return root;

    }

    @Override
    public void removeNode(E e) {
        root = removeNode(root, e);
    }

    private Node removeNode(Node root, E e) {
        if (root == null) {
            return null;
        }
        if ((e.compareTo(root.e)) < 0) {
            root.left = removeNode(root.left, e);
        } else if ((e.compareTo(root.e)) > 0) {
            root.right = removeNode(root.right, e);
        } else {
            if (root.left == null) {
                Node temp = root.right;
                root.right=null;
                size--;
                return temp;
            }
            if (root.right == null) {
                Node temp = root.left;
                root.left=null;
                size--;
                return temp;
            }
            if (root.left != null && root.right != null) {
                Node sccessor = findMin(root.right);
                sccessor.right = removeMin(root.right);
                sccessor.left = root.left;
                root = root.left = root.right = null;
                return sccessor;
            }
        }
        return root;
    }

    @Override
    public void isEmpty() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("当前树为0");
        }
    }

    @Override
    public int size() {
        return size;

    }

    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.e+" ");
        inOrder(root.left);
        inOrder(root.right);
    }


}