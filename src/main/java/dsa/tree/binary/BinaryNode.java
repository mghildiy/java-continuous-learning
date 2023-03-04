package dsa.tree.binary;

import java.util.List;
import java.util.Optional;

public class BinaryNode<T> {
    T data;
    Optional<BinaryNode<T>> left;
    Optional<BinaryNode<T>> right;

    public BinaryNode(T data, Optional<BinaryNode<T>> left, Optional<BinaryNode<T>> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
