package com.hw.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: Webb
 * @Date: 2019/8/20 19:59
 **/
public class HeapOOM {
    /* 测试提交 */
    static class OOMProject{
        int a = 1;
        public void a() {
            a++;
            a();
        }
    }

    /* 测试提交2 */
    public static void main(String[] args) {
//        List<OOMProject> oomProjects = new ArrayList<>();
//        OOMProject oomProject = new OOMProject();
//        while (true) {
////            oomProjects.add(new OOMProject());
//            oomProject.a();
//        }

        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i).intern());
        }
    }
}
