package problems.filesystem;

import problems.filesystem.components.Directory;
import problems.filesystem.components.File;
import problems.filesystem.components.FileSystemComponent;

public class FileSystem {

    private final Directory base;

    private static volatile FileSystem fileSystemInstance;

    private FileSystem() {
        base = new Directory("base", null);
    }

    public static FileSystem getInstance() {
        if(fileSystemInstance == null) {
            synchronized (FileSystem.class) {
                if(fileSystemInstance == null) {
                    fileSystemInstance = new FileSystem();
                }
            }
        }
        return fileSystemInstance;
    }



//     ls, cd .., cd path, mkdir, touch fileName, pwd


    public Directory getBase() {
        return base;
    }

    public void ls() {
        base.ls();
    }

    public void ls(Directory directory) {
        directory.ls();
    }

    public Directory cd(Directory directory) {
        if(directory.getParent() != null) {
            return directory.getParent();
        }
        return directory;
    }

    public Directory cd(Directory directory, String path) {
        Directory dir = directory;
        String[] paths = path.split("/");
        int i =0;
        while (i<paths.length && dir.getElements().containsKey(paths[i])
                && dir.getElements().get(paths[i]) instanceof Directory) {
            dir = (Directory) dir.getElements().get(paths[i++]);
        }
        if(i == paths.length) {
            return dir;
        }
        System.out.println("Invalid path");
        return null;
    }

    public void mkdir(String name) {
        FileSystemComponent newDirectory = new Directory(name, base);
        base.addElement(newDirectory);
    }

    public void mkdir(Directory directory, String name) {
        FileSystemComponent newDirectory = new Directory(name, directory);
        directory.addElement(newDirectory);
    }

    public void touch(Directory directory, String name) {
        File file = new File(name, directory);
        directory.addElement(file);
    }

    public void pwd(Directory directory) {
        directory.pwd();
    }




}
