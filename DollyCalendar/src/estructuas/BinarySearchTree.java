/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuas;

/**
 *
 * @author JAndres
 */
class BinarySearchTree <T extends Comparable<T>>{
    class NodeBST <T>{
        T key;
        NodeBST<T> left, right;
        public NodeBST(T item) {
            key = item;
            left = right = null;
        }
    }
    
    NodeBST root;

    BinarySearchTree() {
        root = null;
    }

    
    void deleteKey(T key) {
        root = deleteRec(root, key);
    }
    
    NodeBST deleteRec(NodeBST root, T key) {
        if (root == null) {
            return root;
        }
        if (key.compareTo((T) root.key)<0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo((T) root.key)>0) {
            root.right = deleteRec(root.right, key);
        } 
        else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, (T) root.key);
        }
        return root;
    }

    T minValue(NodeBST root) {
        T minv = (T) root.key;
        while (root.left != null) {
            minv = (T) root.left.key;
            root = root.left;
        }
        return minv;
    }
    
    void insert(T key) {
        root = insertRec(root, key);
    }
    
    NodeBST insertRec(NodeBST root, T key) {
        if (root == null) {
            root = new NodeBST(key);
            return root;
        }
        if (key.compareTo((T) root.key)<0) {
            root.left = insertRec(root.left, key);
        } else if (key.compareTo((T) root.key)>0) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }
    
    void inorder() {
        inorderRec(root);
    }
    
    void inorderRec(NodeBST root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}
