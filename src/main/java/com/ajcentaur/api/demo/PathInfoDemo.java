package com.ajcentaur.api.demo;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfoDemo {
    static void show(String id, Object obj){
        System.out.println(id + obj);
    }

    static void info(Path path){
        show("path.toString():\n", path.toString());
        show("Files.exists(): ", Files.exists(path));
        show("Files.isRegularFile(): ", Files.isRegularFile(path));
        show("Files.isDirectory(): ", Files.isDirectory(path));
        show("path.isAbsolute(): ", path.isAbsolute());
        show("path.getFileName(): ", path.getFileName());
        show("path.getParent(): ", path.getParent());
        show("path.getRoot(): ", path.getRoot());
        System.out.println("**************************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("D:","path","to","nowhere","NoFile.txt"));
        Path path = Paths.get("PathInfoDemo.java");
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
//        info(puri);
        System.out.println(Files.exists(puri));

    }

}
