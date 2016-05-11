package com.bruce.classpathdemo;

import java.io.File;

/**
 * Created by wuteng1 on 2016/5/11.
 */
public class FindClassPath {
    public static void main(String[] args) {
        //例如在d盘下运行java命令，则当前目录是d
        //虚拟机的调用路径即是当前路径，在ide下就是文件的目录
        File file = new File(".");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        //类加载路径
        System.out.println(FindClassPath.class.getClassLoader().getResource(""));
    }
}
