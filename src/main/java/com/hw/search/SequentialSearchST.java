package com.hw.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hewei
 * @Description: 无序链表中的顺序查找  3.1.4
 * @Date: Created in 10:58 2018/4/18
 */
public class SequentialSearchST<K, V> {

    /**
     * 链表首节点
     */
    private Node first;

    /**
     * 链表内存储数据数
     */
    private Integer size;

    /**
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        size = (size == null) ? 0 : size;
        for (Node n = first; n != null; n = n.next) {
            if (n.key.equals(key)) {
                n.value = value;
                size ++;
                return;
            }
        }

        first = new Node(key, value, first);
        size ++;
    }


    /**
     *
     * @param key
     * @return
     */
    public V get(K key) {
        for (Node n = first; n != null; n = n.next) {
            if (n.key.equals(key)) {
                return n.value;
            }
        }

        return null;
    }


    public Integer size() {
        return size;
    }


    public List<K> keys() {
        List<K> keys = new ArrayList<K>();
        for (Node n = first; n != null; n = n.next) {
            keys.add(n.key);
        }

        return keys;
    }


    /**
     * 即时型删除
     */
    public void delete(K k) {

        Node pre = null;
        for (Node n = first; n != null; pre = n, n = n.next) {
            if (n.key.equals(k)) {
                //n 是首节点
                if (n == first) {
                    first = n.next;
                } else {
                    //从链表中去除该节点
                    pre.next = n.next;
                }
            }
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
         * 链表下一节点
         */
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        SequentialSearchST<Integer, String> st = new SequentialSearchST<Integer, String>();
        for (int i = 0; i < 100; i ++) {
            st.put(i, String.valueOf(i));
        }

        st.delete(10);

        System.out.println(st.get(10));
        System.out.println(st.get(11));
        System.out.println(st.get(9));
    }

}
