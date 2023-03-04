package dsa.tree.binary;

import java.util.*;

public class BinarySearchTree<T> implements Tree<T>{

    private Optional<BinaryNode<T>> root = Optional.empty();

    private Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Optional<BinaryNode<T>> root() {
        return this.root;
    }

    @Override
    public void insert(T value) {
        /*if(root.isEmpty()) {
            root = createNewNode(value);
            return;
        }
        insertRecursively(root, value);*/
        this.root = insertRecursivelyAlt(this.root, value);
    }

    private void insertRecursively(Optional<BinaryNode<T>> root, T value) {
        BinaryNode<T> node = root.get();
        int comparison = this.comparator.compare(node.data, value);
        if(comparison == 0) {
            return;
        } else {
            if(comparison > 0) {
                node.left = checkWithChild(node.left, value);
            } else {
                node.right = checkWithChild(node.right, value);
            }
        }
    }

    private Optional<BinaryNode<T>> insertRecursivelyAlt(Optional<BinaryNode<T>> root, T value) {
        if(root.isEmpty()) {
            root = createNewNode(value);
        } else {
            BinaryNode<T> node = root.get();
            int comparison = this.comparator.compare(node.data, value);
            if(comparison != 0) {
                if(comparison > 0) {
                    node.left = insertRecursivelyAlt(node.left, value);
                } else {
                    node.right = checkWithChild(node.right, value);
                }
            }
        }

        return root;
    }

    private Optional<BinaryNode<T>> checkWithChild(Optional<BinaryNode<T>> childMayBe, T value) {
        if(childMayBe.isPresent()) {
            insertRecursively(childMayBe, value);
            return childMayBe;
        } else {
            childMayBe = createNewNode(value);
            return childMayBe;
        }
    }

    private Optional<BinaryNode<T>> createNewNode(T value) {
        return Optional.of(new BinaryNode(value, Optional.empty(), Optional.empty()));
    }

    @Override
    public boolean search(T value) {
        return searchRecursively(this.root, value);
    }

    private boolean searchRecursively(Optional<BinaryNode<T>> root, T value) {
        if(root.isEmpty()) return false;
        if(this.comparator.compare(root.get().data, value) == 0) return true;
        if(this.comparator.compare(root.get().data, value) > 0) return searchRecursively(root.get().left, value);
        else return searchRecursively(root.get().right, value);
    }

    private void printNode(Optional<BinaryNode<T>> nodeMayBe) {
        if(nodeMayBe.isPresent()) {
            BinaryNode<T> node = nodeMayBe.get();
            String childL = node.left.isPresent() ? node.left.get().data.toString() : "null";
            String childR = node.right.isPresent() ? node.right.get().data.toString() : "null";
            System.out.println(node.data + " ----> " + childL + " - " + childR);
            printNode(node.left);
            printNode(node.right);
        }

    }

    public void  printTree() {
        printNode(this.root);
    }


    public static void main(String[] args) {
        Comparator<Integer> comparator = (Integer a, Integer b) -> {
            return Integer.compare(a, b);
        };
        BinarySearchTree<Integer> bst = new BinarySearchTree(comparator);
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(25);
        bst.insert(8);
        bst.insert(12);
        bst.insert(10);// duplicate

        bst.printTree();

        System.out.println(bst.search(8));
        System.out.println(bst.search(12));
        System.out.println(bst.search(32));
    }
}
