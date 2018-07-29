package com.hw.search;

/**
 * @Author: Hewei
 * @Description: 二叉查找树 实现 3.3.1
 * @Date: Created in 14:28 2018/4/18
 */
public class BST <K extends Comparable<K>, V> {

    /**
     * 根节点
     */
    private Node root;

    public Integer size() {
        return size(root);
    }


    private Integer size(Node n) {
        if (n == null) {
            return 0;
        } else {
            return n.size;
        }
    }


    /**
     * 查找以n为根节点的数中键值为key的value
     * @param n
     * @param key
     * @return
     */
    private V get(Node n, K key) {
        if (n == null) {
            return null;
        } else {
            int compare = n.key.compareTo(key);
            if (compare > 0) {
                return get(n.right, key);
            } else if (compare < 0){
                return get(n.left, key);
            } else {
                return n.value;
            }
        }
    }


    /**
     * 在以n为根节点的树中插入
     * @param n
     * @param key
     * @param value
     * @return
     */
    private Node put(Node n, K key, V value) {
        if (n == null) {
            return new Node(key, value, null, null, 1);
        } else {
            int compare = n.key.compareTo(key);
            if (compare > 0) {
                //左子树中插入
                n.left = put(n.left, key, value);
            } else if (compare < 0) {
                //右子树中插入
                n.right = put(n.right, key, value);
            } else {
                n.value = value;
            }
            //权计算
            n.size = size(n.left) + size(n.right) + 1;
            return n;
        }
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }



    /**
     * 节点查找
     * @param key
     * @return
     */
    public V get(K key) {
        return get(root, key);
    }


    /**
     * 查找二叉树中的最小键值
     * @return
     */
    public K min () {
        return min(root).key;
    }


    private Node min(Node n) {
        if (n.left == null) {
            return n;
        } else {
            return min(n);
        }
    }



    public K max() {
        return max(root).key;
    }


    private Node max(Node n) {
        if (n.right == null) {
            return n;
        } else {
            return max(n.right);
        }
    }



    /**
     * 内部数据存储结构
     */
    private class Node {

        /**
         * 键
         */
        K key;

        /**
         * 值
         */
        V value;

        /**
         * 树节点左子节点
         */
        Node left;


        /**
         * 树节点右子节点
         */
        Node right;


        /**
         * 以该节点为根的树的节点数，权重
         */
        int size;


        public Node(K key, V value, Node left, Node right, int n) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            size = n;
        }
    }

}
