package com.bruce.classpathdemo;

import java.io.File;

/**
 * Created by wuteng1 on 2016/5/11.
 */
public class FindClassPath {
    public static void main(String[] args) {
        //������d��������java�����ǰĿ¼��d
        //������ĵ���·�����ǵ�ǰ·������ide�¾����ļ���Ŀ¼
        File file = new File(".");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        //�����·��
        System.out.println(FindClassPath.class.getClassLoader().getResource(""));
    }
}
