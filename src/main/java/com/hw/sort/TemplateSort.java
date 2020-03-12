package com.hw.sort;

/**
 * @Author: Hewei
 * @Description: 模板排序类
 * @Date: Created in 9:22 2019/5/14
 */
public abstract class TemplateSort {

    public abstract void sort(Comparable<Comparable>[] a);

    /**
     * 比较两个对象的大小
     * @param a 对象a
     * @param b 对象b
     * @return a < b return true, a > b return false
     */
    protected boolean less (Comparable<Comparable> a, Comparable<Comparable> b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 交换数组下标i,j处的数据
     * @param a 数组
     * @param i 下标
     * @param j 下标
     */
    protected void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印数组
     * @param a 数组
     */
    protected void show(Comparable[] a) {
        for (Comparable c : a) {
            System.out.println(c);
        }
    }

    /**
     * 数组是否有序
     * @param a 数组
     * @return 是否有序
     */
    public boolean isSored(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (less(a[i], a[i+1])) {
                return false;
            }
        }
        return true;
    }
}
