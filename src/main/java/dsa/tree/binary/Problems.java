package dsa.tree.binary;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Problems {

    // Data of root node -> Apply preorder on left subtree of root node -> apply preorder on right subtree of root node
    public static void preOrderTraversal(BinarySearchTree<Integer> tree) {
        preOrderTraversalRecursively(tree.root());
    }

    private static void preOrderTraversalRecursively(Optional<BinaryNode<Integer>> nodeMayBe) {
        if(nodeMayBe.isEmpty()) return;

        BinaryNode node = nodeMayBe.get();
        System.out.println(node.data);
        preOrderTraversalRecursively(node.left);
        preOrderTraversalRecursively(node.right);
    }

    // DFS - inorder, preorder, postorder

    // Apply inorder on left subtree of root node -> Data of root node -> apply preorder on right subtree of root node
    public static void inOrderTraversal(BinarySearchTree<Integer> tree) {
        inOrderTraversalRecursively(tree.root());
    }

    private static void inOrderTraversalRecursively(Optional<BinaryNode<Integer>> nodeMayBe) {
        if(nodeMayBe.isEmpty()) return;

        BinaryNode node = nodeMayBe.get();
        inOrderTraversalRecursively(node.left);
        System.out.println(node.data);
        inOrderTraversalRecursively(node.right);
    }

    // Apply postorder on left subtree of root node -> apply preorder on right subtree of root node -> Data of root node
    public static void postOrderTraversal(BinarySearchTree<Integer> tree) {
        postOrderTraversalRecursively(tree.root());
    }

    private static void postOrderTraversalRecursively(Optional<BinaryNode<Integer>> nodeMayBe) {
        if(nodeMayBe.isEmpty()) return;

        BinaryNode node = nodeMayBe.get();
        postOrderTraversalRecursively(node.left);
        postOrderTraversalRecursively(node.right);
        System.out.println(node.data);
    }

    // BFS
    public static void leverOrderTraversal(BinarySearchTree<Integer> tree) {
        if(tree.root().isEmpty()) return;

        Queue<BinaryNode<Integer>> nodesToTraverse = new LinkedList<>();
        nodesToTraverse.add(tree.root().get());

        BinaryNode<Integer> currentNode = nodesToTraverse.poll();
        while(currentNode != null) {
            System.out.println(currentNode.data);
            if(currentNode.left.isPresent())
                nodesToTraverse.add(currentNode.left.get());
            if(currentNode.right.isPresent())
                nodesToTraverse.add(currentNode.right.get());
            currentNode = nodesToTraverse.poll();
        }
    }

    public static int findTreeHeight(BinarySearchTree<Integer> tree) {
        if(tree.root().isEmpty()) return 0;
        return findHeightOfTreeRecursively(tree.root());
    }

    public static<T> int findHeightOfTreeRecursively(Optional<BinaryNode<T>> nodeMayBe) {
        if(nodeMayBe.isEmpty()) return -1;
        BinaryNode<T> node = nodeMayBe.get();
        return 1 + Math.max(findHeightOfTreeRecursively(node.left), findHeightOfTreeRecursively(node.right));
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

        System.out.println("Pre-order traversal");
        preOrderTraversal(bst);

        System.out.println("In-order traversal");
        inOrderTraversal(bst);

        System.out.println("Post-order traversal");
        postOrderTraversal(bst);

        System.out.println("Level-order traversal");
        leverOrderTraversal(bst);

        System.out.println("Tree height:"+ findTreeHeight(bst));
        BinarySearchTree<Integer> skewedBst = new BinarySearchTree(comparator);
        skewedBst.insert(100);
        skewedBst.insert(90);
        skewedBst.insert(80);
        skewedBst.insert(70);
        skewedBst.insert(60);
        System.out.println("Skewed tree height:"+ findTreeHeight(skewedBst));
        System.out.println("Empty tree height:"+ findTreeHeight(new BinarySearchTree(comparator)));
        BinarySearchTree<Integer> singleNodeBT = new BinarySearchTree(comparator);
        singleNodeBT.insert(100);
        System.out.println("Single node tree height:"+ findTreeHeight(singleNodeBT));
    }
}
