package com.ajcentaur.api;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    static void show(String id, Object obj){
        System.out.println(id + obj);
    }

    static void info(Path path){
        show("path.toString():\n", path.toString()); //路径的完整表示
        show("Files.exists(): ", Files.exists(path));   //是否存在
        show("Files.isRegularFile(): ", Files.isRegularFile(path)); //是否为普通文件
        show("Files.isDirectory(): ", Files.isDirectory(path)); //是否为目录
        show("path.isAbsolute(): ", path.isAbsolute());
        show("path.getFileName(): ", path.getFileName());
        show("path.getParent(): ", path.getParent());
        show("path.getRoot(): ", path.getRoot());
        System.out.println("**************************");
    }

    public static void main(String[] args) {
//        Properties properties = System.getProperties();
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("D:","path","to","nowhere","NoFile.txt"));
        Path path = Paths.get("src/main/java/com/ajcentaur/api/demo/PathInfoDemo.java");
        info(path);
        Path aPath = path.toAbsolutePath();
        info(aPath);
        info(aPath.getParent());
        try {
            info(path.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
        URI uri = path.toUri();
        System.out.println("URI:\n" + uri);
        Path puri = Paths.get(uri);
        info(puri);
        System.out.println(Files.exists(puri));
        File file = aPath.toFile();
    }

}
